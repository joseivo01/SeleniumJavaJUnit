package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import utils.ElementUtil;
import utils.OptionsManager;

public abstract class BasePage {
    public WebDriver driver;
    public Properties properties;
    // Add comment
    // Created:
    public OptionsManager optionsManager;

    // add seletor
    @FindBy(css="input[name='home'][value='Home']")
    private WebElement homeButton;

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver initDriver(String browser){
        System.out.println("Browser value is : " + browser);
        optionsManager = new OptionsManager(properties);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
        }

        else if (browser.equalsIgnoreCase("safari")) {
            tlDriver.set(new SafariDriver());
        }

        else {
            System.out.println("Please enter the right browser name : " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        ElementUtil.implicitlyWait(getDriver(), 10, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
