package tests;

import org.junit.jupiter.api.Test;
import pageobjects.DashboardPage;
import pageobjects.LogInPage;
import pageobjects.RegisterPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAuthTest extends BaseTest {

    LogInPage loginPage;
    DashboardPage dashboardPage;
    RegisterPage registerPage;


    @Test
    void userCanRegister() {

        dashboardPage = new DashboardPage(driver);
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();

        String name = utils.GenerateUnits.generateRandomUsername();
        registerPage.typeName(name);
        registerPage.typePassword("admin@A123");
        registerPage.typePasswordConfirmation("admin@A123");
        registerPage.clickCreateButton();

        String actualMessage = dashboardPage.getLoginMessage();
        String expectedMessage = "Skaičiuotuvas";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void userCanNotRegister() {

        registerPage = new RegisterPage(driver);

        registerPage.clickRegisterButton();
        String name = utils.GenerateUnits.generateRandomUsername();
        registerPage.typeName(name);
        registerPage.typePassword("admin@A123");
        registerPage.typePasswordConfirmation("DifferentPass!@#123");
        registerPage.clickCreateButton();

        String actualMessage = registerPage.getNotMatchPassMessage();
        String expectedMessage = "Įvesti slaptažodžiai nesutampa";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void userCanLogin() {

        loginPage = new LogInPage(driver);
        dashboardPage = new DashboardPage(driver);

        LogInPage.typeLoginPassword("admin@A123");
        LogInPage.typeLoginUsername("Karolis");
        LogInPage.clickSignInButton();

        String actualMessage = dashboardPage.getLoginMessage();
        String expectedMessage = "Skaičiuotuvas";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void userCanNotLogin() {

        loginPage = new LogInPage(driver);

        LogInPage.typeLoginPassword("a@A123");
        LogInPage.typeLoginUsername("Karolis");
        LogInPage.clickSignInButton();

        String actualMessage = LogInPage.getNotLoginMessage();
        String expectedMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void createNewEntry() {

        loginPage = new LogInPage(driver);
        dashboardPage = new DashboardPage(driver);

        LogInPage.typeLoginPassword("admin@A123");
        LogInPage.typeLoginUsername("Karolis");
        LogInPage.clickSignInButton();
        dashboardPage.clearFirstDigit();
        dashboardPage.clearSecondDigit();
        dashboardPage.typeDigitOne("5");
        dashboardPage.typeDigitTwo("5");
        dashboardPage.clickCalculationButton();

        String actualMessage = dashboardPage.getCalculationResult();
        String expectedMessage = "5 + 5 = 10";

        assertEquals(expectedMessage, actualMessage);


    }

    @Test
    void canNotCreateNewEntry() {

        loginPage = new LogInPage(driver);
        dashboardPage = new DashboardPage(driver);
        registerPage = new RegisterPage(driver);

        LogInPage.typeLoginPassword("admin@A123");
        LogInPage.typeLoginUsername("Karolis");
        LogInPage.clickSignInButton();
        dashboardPage.clearFirstDigit();
        dashboardPage.clearSecondDigit();
        dashboardPage.typeDigitOne("-4");
        dashboardPage.typeDigitTwo("-3");
        dashboardPage.clickCalculationButton();

        String actualMessage = dashboardPage.getNegativeCalculationResult();
        String expectedMessage = "Validacijos klaida: skaičius negali būti neigiamas";

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void currentEntrySearch() {

        loginPage = new LogInPage(driver);
        dashboardPage = new DashboardPage(driver);

        LogInPage.typeLoginPassword("admin@A123");
        LogInPage.typeLoginUsername("Karolis");
        LogInPage.clickSignInButton();
        dashboardPage.clearFirstDigit();
        dashboardPage.clearSecondDigit();
        dashboardPage.typeDigitOne("8");
        dashboardPage.typeDigitTwo("7");
        dashboardPage.clickCalculationButton();
        dashboardPage.clickOperationsButton();

        String actualMessage = dashboardPage.getOperationResult();
        String expectedMessage = "15";

        assertEquals(expectedMessage, actualMessage);


    }

    @Test
    void currentNegativeEntrySearch() {

        loginPage = new LogInPage(driver);
        dashboardPage = new DashboardPage(driver);

        LogInPage.typeLoginPassword("admin@A123");
        LogInPage.typeLoginUsername("Karolis");
        LogInPage.clickSignInButton();
        dashboardPage.clearFirstDigit();
        dashboardPage.clearSecondDigit();
        dashboardPage.typeDigitOne("7");
        dashboardPage.typeDigitTwo("7");
        dashboardPage.clickCalculationButton();
        dashboardPage.clickOperationsButton();

        String actualMessage = dashboardPage.getNegativeOperationResult();
        String expectedMessage = "15";

        assertEquals(expectedMessage, actualMessage);


    }


}
