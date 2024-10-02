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
    private final By designerButton = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href = '/']");
    //локатор логотипа
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //локатор загрузки профиля
    private final By profileField = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");
    //локатор кнопки выхода
    private final By logOutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    //клик по "конструктор"
    public void clickDesignerButton() {
        driver.findElement(designerButton).click();
    }
    //клик по логотипу
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
    //клик на выход
    public void clickLogOutButton(){
        driver.findElement(logOutButton).click();
    }
    //ожидание загрузки страницы профиля
    public void waitForLoadProfileField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileField));
    }
    //найти элемент профиля
    public WebElement findProfile() {
        return driver.findElement(profileField);
    }
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
}
