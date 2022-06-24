#Martin Bachev
Feature: Test areWordsEqual and areSentencesEqual methods in StringHelper.class

  Background:
    Given Case sensitivity is False

  @areWordsEqual
  Scenario: Test areWordsEqual method
    And first word equals to "Cucumber" аnd second word equals to "cucumber"
    When User call areWordsEqual method
    Then User verify that the both words are equal

  @areWordsEqual
  Scenario: Test areSentencesEqual method
    And first sentence equals to "Cucumber is amazing!" аnd second sentence equals to "cucumber is amazing!"
    When User call areSentencesEqual method
    Then User verify that the both sentences are equal

