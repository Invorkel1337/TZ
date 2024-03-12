package pages;

import org.testng.annotations.Test;

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
}
