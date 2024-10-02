package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    private WebDriver driver;
    //локатор поля email
    private final By emailField = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'text']");
    //локатор поля пароль
    private final By passwordField = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'password']");
    //локатор кнопки "войти"
    private final By logInButton = By.xpath(".//button[text()='Войти']");
    //локатор "Зарегистрироваться"
    private final By registrationButtonLoginPage = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    //локатор "Восстановить пароль"
    private final By forgotPasswordButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");
    //локатор заголовка "Вход"
    private final By enterField = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    //заполнить поле email и пароль
    public void enterInputEmailAndPassword(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }
    //клик на кнопку войти
    public void clickLoginButton() {
        driver.findElement(logInButton).click();
    }
    //ожидание загрузки страницы входа
    public void waitForLoadLogInField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterField));
    }
    //клик на кнопку "зарегистрироваться"
    public void clickRegistrationButtonLoginPage() {
        driver.findElement(registrationButtonLoginPage).click();
    }
    //клик на кнопку "восстановить пароль"
    public  void  clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }
    //найти кнопку "войти"
    public WebElement findEnterButton() {
        return driver.findElement(logInButton);
    }

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }
}
