package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    private WebDriver driver;

    //локатор кнопки "Войти"
    private final By forgotLogInButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    //локатор поля "восстановление пароля"
    private final By resetPassword = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    //клик по кнопке "Войти"
    public void clickLogInButton() {
        driver.findElement(forgotLogInButton).click();
    }
    //ожидание загрузки страницы восстановления пароля
    public void waitForLoadResetField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPassword));
    }
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
}
