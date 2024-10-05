package PageObject;

import org.openqa.selenium.By;
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
    private final By sauceField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    //локатор поля "начинки"
    private final By fillingField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");
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
    //найти "флюорисцентная булка"
    public WebElement findFluorescentBread() {
       return driver.findElement(fluorescentBreadButton);
    }
    //найти "соус Spicy-X"
    public WebElement findSpicyX() {
       return driver.findElement(spicyXButton);
    }
    //найти "говяжий метеорит (отбивная)"
    public WebElement findMeteorite() {
        return driver.findElement(meteoriteButton);
    }
    //ожидание загрузки главной страницы
    public void waitForConstructBurgerField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructBurgerField));
    }
    //найти элемент соберите бургер
    public WebElement findConstructBurgerField() {
        return driver.findElement(constructBurgerField);
    }


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
}
