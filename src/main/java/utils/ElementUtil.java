package utils;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.annotation.Internal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
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
        driver.manage().timeouts().implicitlyWait(timeOut, timeUnit);
    }

    public static String getScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try{
            FileUtils.copyFile(src, destination);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return path;
    }
}
