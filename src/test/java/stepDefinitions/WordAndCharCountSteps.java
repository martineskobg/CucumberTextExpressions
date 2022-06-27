package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static helpers.StringHelper.*;

public class WordAndCharCountSteps {
    private String text;
    private int wordCount;
    private int charCount;

    @Given("input text")
    public void theFollowingText(String text) {
        this.text = text;
    }

    @When("User call getWordsCountFromText method")
    public void userCallGetWordsCountFromTextMethod() {
        wordCount = getWordsCountFromText(text);
    }

    @Then("verify the input text word(s) count is equal to {int}")
    public void userVerifyThatTheCountOfTheWordsIsEqualTo(int expectedCount) {
        Assert.assertEquals("Word Count must be equals to " + expectedCount + " but Word Count != "
                + expectedCount, expectedCount, wordCount);
    }

    @When("User call getCharsCount method")
    public void userCallGetCharsCountMethod() {
        charCount = getCharsCount(text);
    }

    @Then("verify the input text char count is equal to {int}")
    public void userVerifyTheCountOfCharactersIs(int characterCount) {
        Assert.assertEquals("Character Count must be equals to " + charCount + " but Character Count != "
                + charCount, characterCount, charCount);
    }

    @When("all whitespaces before {} are removed")
    public void allWhitespacesBeforeAreRemoved(char character) {
        text = removeWhitespaceBeforeChar(character, text);
    }

    @And("all consecutive whitespace chars are replaced with a single space")
    public void allConsecutiveWhitespaceCharsAreReplacedWithASingleSpace() {
        text = removeWhitespaces(text);
        // take word(s) count from the text
        userCallGetWordsCountFromTextMethod();
        userCallGetCharsCountMethod();
    }

}
