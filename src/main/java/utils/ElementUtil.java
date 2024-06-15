package utils;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.annotation.Internal;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ElementUtil {
    public static int implicitWait;
    public static int explicitWait;
    public static int pageRefreshWait;

    public ElementUtil(Properties properties){
        implicitWait = Integer.parseInt(properties.getProperty("driver.wait.implicitWait").trim());
        explicitWait = Integer.parseInt(properties.getProperty("driver.wait.explicitWait").trim());
        pageRefreshWait = Integer.parseInt(properties.getProperty("diver.wait.pageRefreshWait").trim());
    }

    public static void implicitlyWait(WebDriver driver, int timeOut, TimeUnit timeUnit) {
        Duration duration;
        switch (timeUnit) {
            case SECONDS:
                duration = Duration.ofSeconds(timeOut);
                break;
            case MILLISECONDS:
                duration = Duration.ofMillis(timeOut);
                break;
            case MINUTES:
                duration = Duration.ofMinutes(timeOut);
                break;
            default:
                throw new IllegalArgumentException("Unsupported TimeUnit: " + timeUnit);
        }
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public static String getScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static Boolean waitForElementVisibility(WebDriver driver, WebElement element) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(explicitWait))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(WebDriverException.class);

            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
