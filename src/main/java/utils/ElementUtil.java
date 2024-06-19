package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

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

    public ElementUtil(Properties properties) {
        implicitWait = Integer.parseInt(properties.getProperty("driver.wait.implicitWait").trim());
        explicitWait = Integer.parseInt(properties.getProperty("driver.wait.explicitWait").trim());
        pageRefreshWait = Integer.parseInt(properties.getProperty("driver.wait.pageRefreshWait").trim());
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

    public static void waitForPageToLoad(WebDriver driver) {
        waitForPageToLoad(driver, pageRefreshWait);
    }

    public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForUrlToBe(WebDriver driver, String expectedUrl, int timeoutInSeconds) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
