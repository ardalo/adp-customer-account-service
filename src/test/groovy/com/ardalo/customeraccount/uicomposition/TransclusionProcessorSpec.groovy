package com.ardalo.customeraccount.uicomposition

import spock.lang.Specification

class TransclusionProcessorSpec extends Specification {

  def transclusionProcessor = new TransclusionProcessor()

  def "should have tolerant fragment matching pattern"() {
    expect:
    transclusionProcessor.findFragments(inputBody).first().originalTag == expectedFragmentTag

    where:
    inputBody                                                     | expectedFragmentTag
    "<fragment src=\"https://example.com\">"                      | "<fragment src=\"https://example.com\">"
    "<div><fragment src=\"https://example.com\"></div>"           | "<fragment src=\"https://example.com\">"
    "<div><fragment src=\"https://example.com\" foo=\">\"></div>" | "<fragment src=\"https://example.com\" foo=\">\">"
    "<fragment src=\"test\">"                                     | "<fragment src=\"test\">"
    "<fragment src=\"test\"/>"                                    | "<fragment src=\"test\"/>"
    "<fragment src=\"test\" />"                                   | "<fragment src=\"test\" />"
    "<fragment   src=\"test\"/>"                                  | "<fragment   src=\"test\"/>"
    "<fragment   src=\"test\"  >"                                 | "<fragment   src=\"test\"  >"
  }

  def "should find all fragments in input body"() {
    expect:
    transclusionProcessor.findFragments("""
      <html>
      <head>
        <fragment src="https://foo.bar/baz?test=123" />
        <title>Foo</title>
        <fragment foo="bar" src="https://foo.bar/baz?test=456">
      </head>
      <body>
        <fragment src="https://foo.bar/baz?test=789">
      </body>
      </html>
    """) == [
      new Fragment("<fragment src=\"https://foo.bar/baz?test=123\" />"),
      new Fragment("<fragment foo=\"bar\" src=\"https://foo.bar/baz?test=456\">"),
      new Fragment("<fragment src=\"https://foo.bar/baz?test=789\">")
    ] as Set
  }

  def "should treat identical fragments as one fragment"() {
    expect:
    transclusionProcessor.findFragments("""
      <html>
      <head>
        <fragment src="https://foo.bar/baz?test=123" />
        <fragment src="https://foo.bar/baz?test=123">
        <title>Foo</title>
        <fragment foo="bar" src="https://foo.bar/baz?test=456">
        <fragment foo="bar" src="https://foo.bar/baz?test=456">
      </head>
      <body>
        <fragment src="https://foo.bar/baz?test=789">
        <fragment src="https://foo.bar/baz?test=789">
      </body>
      </html>
    """) == [
      new Fragment("<fragment src=\"https://foo.bar/baz?test=123\" />"),
      new Fragment("<fragment foo=\"bar\" src=\"https://foo.bar/baz?test=456\">"),
      new Fragment("<fragment src=\"https://foo.bar/baz?test=789\">")
    ] as Set
  }
}
