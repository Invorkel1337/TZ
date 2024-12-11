package Test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CalculatorTest {
        @Test
    public  void testNumb() {

            CalculatorPage calculatorPage = new CalculatorPage();
            calculatorPage.openPage();
            calculatorPage.scrollToBottom();
            calculatorPage.selectBuild("Prototype");
            calculatorPage.enterFirstNumber("2");
            calculatorPage.enterSecondNumber("3");
            calculatorPage.selectOperation("Subtract");
            calculatorPage.clickCalculate();
            calculatorPage.checkAnswer("-1");
            calculatorPage.sleep(2000);
    }
    @Test
    public void testString(){

            CalculatorPage calculatorPage = new CalculatorPage();
            calculatorPage.openPage();
            calculatorPage.scrollToBottom();
            calculatorPage.selectBuild("Prototype");
            calculatorPage.enterFirstNumber("gs");
            calculatorPage.enterSecondNumber("bu");
            calculatorPage.selectOperation("Concatenate");
            calculatorPage.clickCalculate();
            calculatorPage.checkAnswer("gsbu");
            calculatorPage.sleep(2000);
    }
    @Test
    public void fillFormTest() {
        Configuration.pageLoadTimeout = 60000;
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Vsem privet");
        $("#userEmail").setValue("vsemprivet@mail.ru");
        $("#currentAddress").setValue("Novosibirsk");
        $("#permanentAddress").setValue("Novosibirsk");
        $("#item-1").click();
        $("#output").shouldHave(text("Vsem privet"), text("vsemprivet@mail.ru"), text("Novosibirsk"), text("Novosibirsk"));
    }
}
