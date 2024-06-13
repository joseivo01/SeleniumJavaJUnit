package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private static BasePage basePage;
    protected static Properties properties;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        basePage = new BasePage(){};
        properties = basePage.initProp();
        driver = basePage.initDriver(properties.getProperty("browser"));
    }

    @AfterEach
    public void takesScreenshots()throws IOException{
        ElementUtil.implicitlyWait(driver, 10, TimeUnit.SECONDS);
        ElementUtil.getScreenshot(driver);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
