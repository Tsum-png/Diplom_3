package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private WebDriver driver;
    //локатор кнопки "конструктор"
    private final By designerButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");
    //локатор логотипа
    private final By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a/svg");
    //локатор загрузки профиля
    private final By profileField = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");

    //клик по "конструктор"
    public void clickDesignerButton() {
        driver.findElement(designerButton).click();
    }
    //клик по логотипу
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
    //ожидание загрузки страницы профиля
    public void waitForLoadProfileField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileField));
    }
}
