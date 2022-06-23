#Martin Bachev
Feature: Test getWordsCountFromText and getCharsCount methods in StringHelper.class

  Background:
    Given the following text
  """
  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
  eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
  enim ad minim veniam, quis nostrud exercitation ullamco laboris
  nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
  reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
  pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
  culpa qui officia deserunt mollit anim id est  laborum.
  """

  Scenario: Test getWordsCountFromText method
    When User call getWordsCountFromText method
    Then User verify that words count is 64

  Scenario: Test getCharsCount method
    When User call getCharsCount method
    Then User verify the count of characters is 446
