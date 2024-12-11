package Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RandomNumberPage;

import static org.testng.Assert.assertEquals;

public class RandomNumberTest {

    private RandomNumberPage randomNumberPage;

    @BeforeClass
    public void setUp() {
        randomNumberPage = new RandomNumberPage();
        randomNumberPage.openPage();
    }

    @Test
    public void testMessage() {
        randomNumberPage.scrollToBottom();
        randomNumberPage.selectBuild("Demo");
        randomNumberPage.clickRollTheDiceButton();
        randomNumberPage.setInputValue("string");
        randomNumberPage.clickSubmitButton();
        randomNumberPage.sleep(2000);
        String actualMessage = randomNumberPage.getMessageText();
        assertEquals(actualMessage, "string: Not a number!");
    }
}