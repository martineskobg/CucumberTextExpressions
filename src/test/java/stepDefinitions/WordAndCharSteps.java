package stepDefinitions;

import helpers.StringHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WordAndCharSteps {
    private String text;
    private int count;

    @Given("the following text")
    public void theFollowingText(String text) {
        this.text = text;
    }

    @When("User call getWordsCountFromText method")
    public void userCallGetWordsCountFromTextMethod() {
        count = StringHelper.getWordsCountFromText(text);
    }

    @Then("User verify that word(s) count is {int}")
    public void userVerifyThatTheCountOfTheWordsIsEqualTo(int expectedCount) {
        Assert.assertEquals("Word Count must be equals to " + expectedCount + " but Word Count != "
                + expectedCount, expectedCount,count );
    }

    @When("User call getCharsCount method")
    public void userCallGetCharsCountMethod() {
        count = StringHelper.getCharsCount(text);
    }

    @Then("User verify the count of character(s) is {int}")
    public void userVerifyTheCountOfCharactersIs(int characterCount) {
        Assert.assertEquals("Character Count must be equals to " + count + " but Character Count != "
                + count, count, characterCount);
    }
}
