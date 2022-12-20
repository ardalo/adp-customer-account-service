package com.ardalo.customeraccount.uicomposition;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

@Component
@ConditionalOnProperty(value="ui.composition-enabled", havingValue = "true", matchIfMissing = true)
public class UiCompositionFilter extends OncePerRequestFilter {

  private final TransclusionProcessor transclusionProcessor;

  public UiCompositionFilter(TransclusionProcessor transclusionProcessor) {
    this.transclusionProcessor = transclusionProcessor;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    HttpServletResponse responseToUse = response;

    if (!isAsyncDispatch(request) && !(response instanceof ContentCachingResponseWrapper)) {
      responseToUse = new ContentCachingResponseWrapper(response);
    }

    filterChain.doFilter(request, responseToUse);

    if (!isAsyncStarted(request)) {
      handleResponse(responseToUse);
    }
  }

  private void handleResponse(HttpServletResponse response) throws IOException {
    ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
    Assert.notNull(responseWrapper, "ContentCachingResponseWrapper not found");

    if (shouldApplyTransclusion(responseWrapper)) {
      String encoding = getResponseBodyCharacterEncoding(responseWrapper);
      String originalResponseBody = new String(responseWrapper.getContentAsByteArray(), encoding);
      String processedResponseBody = transclusionProcessor.applyTransclusion(originalResponseBody);
      responseWrapper.resetBuffer();
      responseWrapper.getOutputStream().write(processedResponseBody.getBytes(encoding));
    }

    responseWrapper.copyBodyToResponse();
  }

  /**
   * Indicates whether transclusion should be applied to the response. This
   * is {@code true} if all the following conditions are met:
   * <ul>
   * <li>Response is not committed.</li>
   * <li>Response status code is not in the {@code 1xx} series.</li>
   * <li>Response status code is not in the {@code 3xx} series.</li>
   * <li>Response content type is {@code text/html}.</li>
   * </ul>
   *
   * @param response The HTTP response
   * @return {@code true} if transclusion should be applied to the given response, {@code false} otherwise
   */
  protected boolean shouldApplyTransclusion(HttpServletResponse response) {
    HttpStatus.Series responseStatusCodeSeries = HttpStatus.Series.resolve(response.getStatus());

    return !response.isCommitted()
      && !HttpStatus.Series.INFORMATIONAL.equals(responseStatusCodeSeries)
      && !HttpStatus.Series.REDIRECTION.equals(responseStatusCodeSeries)
      && response.getContentType() != null
      && response.getContentType().toLowerCase().startsWith(MediaType.TEXT_HTML_VALUE);
  }

  protected String getResponseBodyCharacterEncoding(ContentCachingResponseWrapper responseWrapper) {
    return Optional.ofNullable(responseWrapper.getCharacterEncoding()).orElse(WebUtils.DEFAULT_CHARACTER_ENCODING);
  }
}
