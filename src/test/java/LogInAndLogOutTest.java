import Api.ApiStep;
import Api.CreateUser;
import PageObject.ForgotPasswordPage;
import PageObject.LogInPage;
import PageObject.MainPage;
import PageObject.ProfilePage;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class LogInAndLogOutTest {
    private WebDriver driver;
    String email = (RandomStringUtils.randomAlphabetic(7) + "@" + "yandex.ru");
    String password = RandomStringUtils.randomAlphabetic(6);
    String name = RandomStringUtils.randomAlphabetic(5);
    String accessToken;
    private ApiStep apiStep = new ApiStep();

    @Before
    public void setUp(){
        driver = WebDriverFactory.driver("chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        CreateUser user = new CreateUser(email, password, name);
        ValidatableResponse response = apiStep.createUser(user);
        accessToken = response.extract().path("accessToken");
    }

    @After
    public void tearDown() {
        deleteUser();  // Удаление пользователя
        if (driver != null) {
            driver.quit();  // Закрытие браузера
        }
    }

    @Step("Удаление пользователя")
    public void deleteUser() {
        if (accessToken != null) {
            ValidatableResponse response = apiStep.deleteUser(accessToken);
            response.assertThat().statusCode(202); // Проверка, что удаление прошло успешно
        }
    }

    @Test
    public void logInUserProfileTest() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.enterInputEmailAndPassword(email, password);
        logInPage.clickLoginButton();
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        profilePage.waitForLoadProfileField();
        WebElement profileElement = profilePage.findProfile();
        assertTrue("Переход в профиль не выполнен", elementInViewport.isElementInViewport(driver, profileElement));
    }

    @Test
    public void goToConstructorTest() {
            MainPage mainPage = new MainPage(driver);
            LogInPage logInPage = new LogInPage(driver);
            ProfilePage profilePage = new ProfilePage(driver);
            mainPage.waitForConstructBurgerField();
            mainPage.clickProfileButton();
            logInPage.waitForLoadLogInField();
            logInPage.enterInputEmailAndPassword(email, password);
            logInPage.clickLoginButton();
            mainPage.waitForConstructBurgerField();
            mainPage.clickProfileButton();
            profilePage.waitForLoadProfileField();
            profilePage.clickDesignerButton();
            WebElement burgerElement = mainPage.findConstructBurgerField();
            assertTrue("Переход по конструктору не выполнен", elementInViewport.isElementInViewport(driver, burgerElement));
        }

    @Test
    public void goToLogoTest() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.enterInputEmailAndPassword(email, password);
        logInPage.clickLoginButton();
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        profilePage.waitForLoadProfileField();
        profilePage.clickLogoButton();
        WebElement burgerElement = mainPage.findConstructBurgerField();
        assertTrue("Переход по логотипу не выполнен", elementInViewport.isElementInViewport(driver, burgerElement));
    }

    @Test
    public void logOutTest() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.enterInputEmailAndPassword(email, password);
        logInPage.clickLoginButton();
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        profilePage.waitForLoadProfileField();
        profilePage.clickLogOutButton();
        logInPage.waitForLoadLogInField();
        WebElement logInButtonElement = logInPage.findEnterButton();
        assertTrue("Кнопка войти вне видимости", elementInViewport.isElementInViewport(driver, logInButtonElement));
    }
}
