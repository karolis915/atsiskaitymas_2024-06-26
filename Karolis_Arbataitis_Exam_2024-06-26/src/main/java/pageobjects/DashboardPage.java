package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Skaičiuotuvas')]")
    private WebElement loginMessage;
    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement inputDigitOne;
    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement inputDigitTwo;
    @FindBy(css = "body h4")
    private WebElement calculationResult;
    @FindBy(xpath = "//span[@id='sk2.errors']")
    private WebElement negativeCalculationResult;
    @FindBy(xpath = "//input[@value='skaičiuoti']")
    private WebElement calculationButton;
    @FindBy(xpath = "//a[normalize-space()='Atliktos operacijos']")
    private WebElement operationsButton;
    @FindBy(css = "tbody tr:last-child td:nth-child(4)")
    private WebElement operationResult;
    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement clearDigitOne;
    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement clearDigitTwo;
    @FindBy(xpath = "//td[normalize-space()='14']")
    private WebElement operationNegativeResult;

    public String getLoginMessage() {
        return loginMessage.getText();
    }

    public void typeDigitOne(String digit) {
        inputDigitOne.sendKeys(digit);
    }

    public void typeDigitTwo(String digit) {
        inputDigitTwo.sendKeys(digit);
    }

    public String getCalculationResult() {
        return calculationResult.getText();
    }

    public void clickCalculationButton() {
        calculationButton.click();
    }

    public String getNegativeCalculationResult() {
        return negativeCalculationResult.getText();
    }

    public void clickOperationsButton() {
        operationsButton.click();
    }

    public String getOperationResult() {
        return operationResult.getText();
    }

    public String getNegativeOperationResult() {
        return operationNegativeResult.getText();
    }
    public void clearFirstDigit(){
        clearDigitOne.clear();
    }
    public void clearSecondDigit(){
        clearDigitTwo.clear();
    }

}
