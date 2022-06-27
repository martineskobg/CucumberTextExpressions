#Martin Bachev
@count
Feature: Test getWordsCountFromText and getCharsCount methods in StringHelper.class

  Background:
    Given input text
  """
  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
  eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
  enim ad minim veniam, quis nostrud exercitation ullamco laboris
  nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
  reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
  pariatur. Excepteur sint occaecat cupidatat non proident, 3sunt in
  culpa qui officia deserunt mollit anim id est  laborum.
  """

  @getWordsCount
  Scenario: Test getWordsCountFromText method
    When User call getWordsCountFromText method
    Then verify the input text word count is equal to 64

  @getCharsCount
  Scenario: Test getCharsCount method
    When User call getCharsCount method
    Then verify the input text char count is equal to 447
