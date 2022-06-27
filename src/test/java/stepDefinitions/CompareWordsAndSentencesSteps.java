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


    @Given("set case sensitivity to {booleanValue}")
    public void caseSensitivityIs(Boolean caseSensitive) {
        this.caseSensitivityIs = caseSensitive;
    }

    @And("first word/sentence equals to {string} аnd second word/sentence equals to {string}")
    public void firstWordEqualsToAndSecondWordEqualsTo(String firstString, String secondString) {
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
    @Given("first word is {word}")
    public void firstWordIsCucumberaazzAAZZ(String firstString) {
        this.firstString = firstString;
    }

    @And("first occurrence of {} is removed")
    public void firstOccurrenceOfAIsRemoved(Character character) {
        firstString = removeFirstOccurrenceOf(character, firstString);
    }

    @When("second word is {word}")
    public void secondWordIsCucumberazAZ(String secondWord) {
        this.secondString = secondWord;
        this.areEqual = areWordsEqual(this.firstString, this.secondString, caseSensitivityIs);
    }

    @And("all occurrences of {} are removed")
    public void allOccurrencesOfAreRemoved(char digit) {
        this.firstString = removeChar(digit, firstString);
    }

    @Given("first sentence is {string}")
    public void firstSentenceIs(String firstSentence) {
        firstString = firstSentence;
    }

    @When("second sentence is {string}")
    public void secondSentenceIs(String secondSentence) {
        secondString = secondSentence;
        areEqual = areSentencesEqual(firstString, secondString, caseSensitivityIs);
    }
}
