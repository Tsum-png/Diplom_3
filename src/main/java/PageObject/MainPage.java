package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    //локатор кнопки "Личный кабинет"
    private final By profileButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
    //локатор кнопки "Войти в аккаунт"
    private final By logInMainButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    //локатор поля "булки"
    private final By breadField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    //локатор поля "соусы"
    private final By sauceField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    //локатор поля "начинки"
    private final By fillingField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");
    //локатор "флюорисцентная булка"
    private final By fluorescentBreadButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[1]/a[1]/img");
    //локатор "соус Spicy-X"
    private final By spicyXButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[2]/a[1]");
    //локатор "говяжий метеорит (отбивная)"
    private final By meteoriteButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[3]/a[2]");
    //локатор "соберите бургер"
    private final By constructBurgerField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1");


    //клик по "Личный кабинет"
    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }
    //клик по "Войти в аккаунт"
    public void clickLogInMainButton() {
        driver.findElement(logInMainButton).click();
    }
    //клик по "булки"
    public void clickBreadField() {
        driver.findElement(breadField).click();
    }
    //клик по "соусы"
    public void clickSauceField() {
        driver.findElement(sauceField).click();
    }
    //клик по "начинки"
    public void clickFillingField() {
        driver.findElement(fillingField).click();
    }
    //клик по "флюорисцентная булка"
    public void clickFluorescentBreadButton() {
        driver.findElement(fluorescentBreadButton).click();
    }
    //клик по "соус Spicy-X"
    public void clickSpicyXButton() {
        driver.findElement(spicyXButton).click();
    }
    //клик по "говяжий метеорит (отбивная)"
    public void clickMeteoriteButton() {
        driver.findElement(meteoriteButton).click();
    }
    //ожидание загрузки главной страницы
    public void waitForConstructBurgerField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructBurgerField));
    }
}
