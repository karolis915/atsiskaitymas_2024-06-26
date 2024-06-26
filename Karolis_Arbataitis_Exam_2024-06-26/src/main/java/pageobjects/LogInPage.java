package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Prisijungimo vardas']")
    private static WebElement inputUsername;
    @FindBy(xpath = "//input[@placeholder='Slaptažodis']")
    private static WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Prisijungti']")
    private static WebElement signInButton;
    @FindBy(xpath = "//span[contains(text(),'Įvestas prisijungimo vardas ir/ arba slaptažodis y')]")
    private static WebElement userCanNotLogInMessage;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public static void typeLoginPassword(String pass) {
        inputPassword.sendKeys(pass);
    }

    public static void typeLoginUsername(String pass) {
        inputUsername.sendKeys(pass);
    }

    public static void clickSignInButton() {
        signInButton.click();
    }

    public static String getNotLoginMessage() {
        return userCanNotLogInMessage.getText();
    }

}
