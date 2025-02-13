package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager
{
    public static WebDriver driver;
    private static final String BROWSER = "CHROME";
    public static WebDriver getDriver()
    {
        if (driver == null){
            if (BROWSER.equals("CHROME")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--start-maximized");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else if (BROWSER.equals("MOZILLA")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                //driver.manage().window().maximize();
            }
        }
        return driver;
    }

}
