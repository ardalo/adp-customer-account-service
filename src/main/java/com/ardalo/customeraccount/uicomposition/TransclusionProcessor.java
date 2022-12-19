package com.ardalo.customeraccount.uicomposition;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class TransclusionProcessor {

  private static final Pattern FRAGMENT_PATTERN = Pattern.compile("<fragment\s(\"[^\"]*\"|[^\">])*/?>");

  public Set<Fragment> findFragments(String body) {
    Set<Fragment> fragments = new HashSet<>();
    Matcher matcher = FRAGMENT_PATTERN.matcher(body);

    while (matcher.find()) {
      fragments.add(new Fragment(matcher.group(0)));
    }

    return fragments;
  }

  public String applyTransclusion(String body) {
    Set<Fragment> fragments = findFragments(body);

    for (Fragment fragment : fragments) {
      body = body.replace(fragment.getOriginalTag(), fragment.getResolvedContent());
    }

    return body;
  }
}
