package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    //локатор поля "регистрация"
    private final By registrationField = By.xpath("//*[@id=\"root\"]/div/main/div/h2");
    //локатор поля имя
    private final By newNameField = By.xpath(".//label[text()='Имя']/parent::div/input[@class = 'text input__textfield text_type_main-default']");
    //локатор поля пароль
    private final By newPasswordField = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'password']");
    //локатор поля email
    private final By newEmailField = By.xpath(".//label[text()='Email']/parent::div/input[@class = 'text input__textfield text_type_main-default']");
    //локатор кнопки зарегистрироваться
    private final By registrationButton = By.cssSelector("button.button_button_type_primary__1O7Bx");
    //локатор кнопки "войти"
    private final By logInRegistrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    //локатор надписи "некорректный пароль"
    private final By incorrectPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    //регистрация нового пользователя
    public void registrationCorrectUser(String newName, String newPassword, String newEmail){
        driver.findElement(newNameField).sendKeys(newName);
        driver.findElement(newPasswordField).sendKeys(newPassword);
        driver.findElement(newEmailField).sendKeys(newEmail);
    }
    //регистрация нового пользователя с некорректным паролем
    public void registrationUserWithIncorrectPassword(String newName, String newPassword, String newEmail){
        driver.findElement(newNameField).sendKeys(newName);
        driver.findElement(newPasswordField).sendKeys(newPassword);
        driver.findElement(newEmailField).sendKeys(newEmail);
    }
    //клик по кнопке зарегистрироваться
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    //клик по кнопке войти
    public void clickLogInRegistrationButton() {
        driver.findElement(logInRegistrationButton).click();
    }
    //ожидание загрузки страницы регистрации
    public void waitForLoadRegistrationField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationField));
    }
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //найти плашку "некорректный пароль"
    public WebElement findIncorrectPassword() {
        return driver.findElement(incorrectPassword);
    }
}
