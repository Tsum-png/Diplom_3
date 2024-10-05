import Api.ApiStep;
import Api.LogIn;
import PageObject.LogInPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;
    String newEmail = (RandomStringUtils.randomAlphabetic(7) + "@" + "yandex.ru");
    String newPassword = RandomStringUtils.randomAlphabetic(6);
    String incorrectPassword = RandomStringUtils.randomAlphabetic(4);
    String newName = RandomStringUtils.randomAlphabetic(5);
    String accessToken;
    private ApiStep apiStep = new ApiStep();

    @Before
    public void setUp(){
        driver = WebDriverFactory.driver("chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
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
            response.assertThat().statusCode(200); // Проверка, что удаление прошло успешно
        }
    }


    @Test
    public void correctRegistrationTest(){
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.clickRegistrationButtonLoginPage();
        registrationPage.waitForLoadRegistrationField();
        registrationPage.registrationCorrectUser(newName, newPassword, newEmail);
        registrationPage.clickRegistrationButton();
        LogIn login = new LogIn(newEmail, newPassword);
        ValidatableResponse response = apiStep.loginUser(login);
        accessToken = response.extract().path("accessToken");
        assertNotNull("Пользователь не был создан", accessToken);
    }

    @Test
    public void incorrectPasswordRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.waitForConstructBurgerField();
        mainPage.clickProfileButton();
        logInPage.waitForLoadLogInField();
        logInPage.clickRegistrationButtonLoginPage();
        registrationPage.waitForLoadRegistrationField();
        registrationPage.registrationCorrectUser(newEmail, incorrectPassword, newName);
        registrationPage.clickRegistrationButton();
        WebElement incorrectPasswordElement = registrationPage.findIncorrectPassword();
        assertTrue("", elementInViewport.isElementInViewport(driver, incorrectPasswordElement));
    }
}
