package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static helpers.StringHelper.*;
import static org.junit.Assert.assertTrue;

public class CompareWordsAndSentencesSteps {
    private boolean caseSensitivityIs;
    private String firstString;
    private String secondString;
    private boolean areEqual;


    @Given("^set case sensitivity to (\\w+$)$")
    public void caseSensitivityIs(Boolean caseSensitive) {
        this.caseSensitivityIs = caseSensitive;
    }

    @And("^first word equals to (\"[A-Z]{1}\\w+\") аnd second word equals to (\"\\w+\"$)$")
    public void firstWordEqualsToAndSecondWordEqualsTo(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    @And("first sentence equals to (\"[A-Z][^\"]*\") аnd second sentence equals to (\"[^\"]*\"$)$")
    public void firstSentenceEqualsToAndSecondSentenceEqualsTo(String firstString, String secondString) {

        this.firstString = firstString;
        this.secondString = secondString;
    }

    @When("User call areWordsEqual method")
    public void userCallAreWordsEqualMethod() {
        areEqual = areWordsEqual(firstString, secondString, caseSensitivityIs);
    }

    @Then("verify the words/sentences are equal")
    public void userVerifyTheStringsAreEqual() {
        assertTrue("The two strings are not Equal! Sensitivity is set to " + areEqual, areEqual);
    }


    @When("User call areSentencesEqual method")
    public void userCallAreSentencesEqualMethod() {
        areEqual = areSentencesEqual(firstString
                , secondString, caseSensitivityIs);
    }

    /**
     * Cucumber: Regular Expressions
     **/
    @Given("^first word is ([a-zA-Z0-9]+$)$")
    public void firstWordIsCucumberaazzAAZZ(String firstString) {
        this.firstString = firstString;
    }

    @And("^first occurrence of ([a-zA-Z]|[\\(\\)\\[\\]\\{\\}\\:]) is removed$")
    public void firstOccurrenceOfAIsRemoved(Character character) {
        firstString = removeFirstOccurrenceOf(character, firstString);
    }

    @When("^second word is (\\w+$)$")
    public void secondWordIsCucumberazAZ(String secondWord) {
        this.secondString = secondWord;
        this.areEqual = areWordsEqual(this.firstString, this.secondString, caseSensitivityIs);
    }

    @And("^all occurrences of (\\d|[\\.\\?\\!\\;\\,\\-\\']) are removed$")
    public void allOccurrencesOfAreRemoved(char digit) {
        this.firstString = removeChar(digit, firstString);
    }

    @Given("^first sentence is (\\\"[a-zA-Z0-9\\W\\D\\s]+\\\"$)$")
    public void firstSentenceIs(String firstSentence) {
        firstString = firstSentence;
    }

    @When("^second sentence is (\\\"[a-zA-Z0-9\\W\\D\\s]+\\\"$)$")
    public void secondSentenceIs(String secondSentence) {
        secondString = secondSentence;
        areEqual = areSentencesEqual(firstString, secondString, caseSensitivityIs);
    }
}
