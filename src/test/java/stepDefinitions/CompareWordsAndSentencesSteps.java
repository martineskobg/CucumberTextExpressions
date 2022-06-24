package stepDefinitions;

import helpers.StringHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class CompareWordsAndSentencesSteps {
    private boolean caseSensitivityIs;
    private String firstString;
    private String secondString;
    private boolean areEqual;


    @Given("Case sensitivity is {booleanValue}")
    public void caseSensitivityIs(Boolean caseSensitive) {
        this.caseSensitivityIs = caseSensitive;
    }

    @And("first word/sentence equals to {string} аnd second word/sentence equals to {string}")
    public void firstWordEqualsToАndSecondWordEqualsTo(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    @When("User call areWordsEqual method")
    public void userCallAreWordsEqualMethod() {
        areEqual = StringHelper.areWordsEqual(firstString, secondString, caseSensitivityIs);
    }

    @Then("User verify that the both words/sentences are equal")
    public void userVerifyThatTheWordsAreEqual() {
        assertTrue("The two strings are not Equal",areEqual);
    }

    @When("User call areSentencesEqual method")
    public void userCallAreSentencesEqualMethod() {
        areEqual = StringHelper.areSentencesEqual(firstString
        , secondString, caseSensitivityIs);
    }
}
