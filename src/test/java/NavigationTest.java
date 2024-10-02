import PageObject.ForgotPasswordPage;
import PageObject.LogInPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.BASE_URL;
import static org.junit.Assert.assertTrue;

public class NavigationTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebDriverFactory.driver("chrome");
        driver.get(BASE_URL);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void navigationBreadTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickFillingField();
        mainPage.clickBreadField();
        WebElement fluorescentBreadElement = mainPage.findFluorescentBread();
        assertTrue("Флюорисцентный хлеб вне видимости", elementInViewport.isElementInViewport(driver,fluorescentBreadElement));
    }

    @Test
    public void navigationSauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickSauceField();
        WebElement spicyXElement = mainPage.findSpicyX();
        assertTrue("Spicy X вне видимости", elementInViewport.isElementInViewport(driver, spicyXElement));
    }

    @Test
    public void navigationFillingTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickFillingField();
        WebElement meteoriteElement = mainPage.findMeteorite();
        assertTrue("Говяжий метеорит (отбивная) вне видимости", elementInViewport.isElementInViewport(driver, meteoriteElement));
    }

    @Test
    public void navigationLogInInAccountOnMainPageTest(){
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickLogInMainButton();
        logInPage.waitForLoadLogInField();
        WebElement logInButtonElement = logInPage.findEnterButton();
        assertTrue("Кнопка войти вне видимости", elementInViewport.isElementInViewport(driver, logInButtonElement));
    }

    @Test
    public void navigationProfileOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        WebElement logInButtonElement = logInPage.findEnterButton();
        assertTrue("Кнопка войти вне видимости", elementInViewport.isElementInViewport(driver, logInButtonElement));
    }

    @Test
    public void navigationLogInInRegistrationTest(){
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.clickRegistrationButtonLoginPage();
        registrationPage.waitForLoadRegistrationField();
        registrationPage.clickLogInRegistrationButton();
        logInPage.waitForLoadLogInField();
        WebElement logInButtonElement = logInPage.findEnterButton();
        assertTrue("Кнопка войти вне видимости", elementInViewport.isElementInViewport(driver, logInButtonElement));
    }

    @Test
    public void navigationLogInInForgotPasswordTest(){
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.clickForgotPasswordButton();
        forgotPasswordPage.waitForLoadResetField();
        forgotPasswordPage.clickLogInButton();
        logInPage.waitForLoadLogInField();
        WebElement logInButtonElement = logInPage.findEnterButton();
        assertTrue("Кнопка войти вне видимости", elementInViewport.isElementInViewport(driver, logInButtonElement));
    }
}
