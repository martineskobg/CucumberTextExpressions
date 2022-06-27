#Martin Bachev
@equal
Feature: Test areWordsEqual and areSentencesEqual methods in StringHelper.class

  Background:
    Given set case sensitivity to false

  @areWordsEqual
  Scenario: Test areWordsEqual method
    And first word equals to "Cucumber" аnd second word equals to "cucumber"
    When User call areWordsEqual method
    Then verify the words are equal

  @areSentencesEqual
  Scenario: Test areSentencesEqual method
    And first sentence equals to "Cucumber is amazing!" аnd second sentence equals to "cucumber is amazing!"
    When User call areSentencesEqual method
    Then verify the sentences are equal

