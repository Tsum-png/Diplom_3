import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver driver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "yandex":
                driver = initYandexDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser: " + browser);
        }

        return driver;
    }

    private static WebDriver initChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver initYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/yandexdriver.exe");  // Путь к YandexDriver

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Yandex\\Yandex\\YandexBrowser\\Application\\browser.exe");  // Путь к Яндекс.Браузеру

        return new ChromeDriver(options);
    }
}

