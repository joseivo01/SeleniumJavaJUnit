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
    protected static Properties properties;
    protected static WebDriver driver;

    // All methods annotated with @ is executed immediately
    @BeforeAll
    public static void setUp() {
        BasePage basePage = new BasePage();
        properties = basePage.initProp(); // Inicializa a variável 'properties'
        System.out.println(properties.getProperty("driver.base-url"));
        driver = basePage.initDriver(properties.getProperty("driver.browser"));
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
