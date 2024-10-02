package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    //локатор поля "регистрация"
    private final By registrationField = By.xpath("//*[@id=\"root\"]/div/main/div/h2");
    //локатор поля имя
    private final By newNameField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div");
    //локатор поля пароль
    private final By newPasswordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div");
    //локатор поля email
    private final By newEmailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div");
    //локатор кнопки зарегистрироваться
    private final By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //локатор кнопки "войти"
    private final By logInRegistrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    //регистрация нового пользователя
    public void registrationCorrectUser(String newName, String newPassword, String newEmail){
        driver.findElement(newNameField).sendKeys(newName);
        driver.findElement(newPasswordField).sendKeys(newPassword);
        driver.findElement(newEmailField).sendKeys(newEmail);
    }

    //заполнить поле имя
    public void enterInputNewName(String newName) {
        driver.findElement(newNameField).sendKeys(newName);
    }
    //заполнить поле пароль
    public void enterInputNewPassword(String newPassword) {
        driver.findElement(newPasswordField).sendKeys(newPassword);
    }
    //заполнить поле email
    public void enterInputNewEmail(String newEmail) {
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
}
