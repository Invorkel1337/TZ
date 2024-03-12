package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RandomNumberPage {

    private final SelenideElement selectBuild = $(By.id("buildNumber"));
    private final SelenideElement rollTheDiceButton = $(By.id("rollDiceButton"));
    private final SelenideElement input = $(By.id("numberGuess"));
    private final SelenideElement submitButton = $(By.id("submitButton"));
    private final SelenideElement message = $(By.xpath("//*[contains(text(), 'string: Not a number!')]"));

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openPage() {
        open("https://testsheepnz.github.io/random-number.html");
    }

    public void selectBuild(String buildName) {
        selectBuild.selectOption(buildName);
    }

    public void clickRollTheDiceButton() {
        rollTheDiceButton.shouldBe(Condition.visible).click();
    }

    public void scrollToBottom() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void setInputValue(String value) {
        input.setValue(value);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getMessageText() {
        return message.getText();
    }
}