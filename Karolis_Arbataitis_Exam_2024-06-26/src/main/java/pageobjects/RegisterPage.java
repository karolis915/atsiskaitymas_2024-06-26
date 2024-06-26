package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {


    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement inputPasswordConfirmation;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputEmail;
    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement registerButton;
    @FindBy(xpath = "//button[normalize-space()='Sukurti']")
    private WebElement createButton;
    @FindBy(xpath = "//span[@id='passwordConfirm.errors']")
    private WebElement passNotMatchMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void typePassword(String pass) {
        inputPassword.sendKeys(pass);
    }

    public void typePasswordConfirmation(String pass) {
        inputPasswordConfirmation.sendKeys(pass);
    }

    public void typeName(String name) {
        inputEmail.sendKeys(name);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public String getNotMatchPassMessage() {
        return passNotMatchMessage.getText();
    }


}
