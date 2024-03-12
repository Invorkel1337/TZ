package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {
    private final String buildDropdown = "select[id='selectBuild']";
    private final String firstNumber = "input[id='number1Field']";
    private final String secondNumber = "input[id='number2Field']";
    private final String operationDropdown = "select[id='selectOperationDropdown']";
    private final String calculateButton = "input[id='calculateButton']";
    private final String answer = "input[id='numberAnswerField']";

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openPage() {
        Selenide.open("https://testsheepnz.github.io/BasicCalculator.html");
    }

    public void scrollToBottom() {
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void selectBuild(String build) {
        $(buildDropdown).selectOption(build);
    }

    public void enterFirstNumber(String number) {
        $(firstNumber).setValue(number);
    }

    public void enterSecondNumber(String number) {
        $(secondNumber).setValue(number);
    }

    public void selectOperation(String operation) {
        $(operationDropdown).selectOption(operation);
    }

    public void clickCalculate() {
        $(calculateButton).click();
    }

    public String getAnswer() {
        return $(answer).getValue();
    }

    public void checkAnswer(String expectedAnswer) {
        $(answer).shouldHave(Condition.value(expectedAnswer));
        }
}




