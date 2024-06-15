package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import utils.ElementUtil;
import utils.OptionsManager;

public class BasePage {
    public WebDriver driver;
    public Properties properties;
    // Add comment
    // Created:
    public OptionsManager optionsManager;

    // add seletor
    @FindBy(css="input[name='home'][value='Home']")
    private WebElement homeButton;

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public BasePage() {}

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
        ElementUtil.implicitlyWait(getDriver(), 3, TimeUnit.SECONDS);
        return getDriver();
    }

    public synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public Properties initProp() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/java/config/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void closeDriver(){
        if(tlDriver != null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

    public void returnToHome(){
        homeButton.click();
    }
}
