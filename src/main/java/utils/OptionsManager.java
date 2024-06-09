package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {
    // This variable is necessary?
    private Properties properties;
    private ChromeOptions chromeoptions;
    private FirefoxOptions firefoxOptions;

    public OptionsManager(Properties properties){
        this.properties = properties;
    }

    public ChromeOptions getChromeOptions(){
        chromeoptions = new ChromeOptions();
        if(properties.getProperty("driver.browser.headless").trim().equals("true")){
            chromeoptions.addArguments("--headless");}

        if(properties.getProperty("driver.browser.incognito").trim().equals("true")){
            chromeoptions.addArguments("--incognito");}

        return chromeoptions;
    }

    public FirefoxOptions getFirefoxOptions() {
        firefoxOptions = new FirefoxOptions();
        if(properties.getProperty("driver.browser.headless").trim().equals("true")){
            firefoxOptions.addArguments();}
        if(properties.getProperty("driver.browser.incognito").trim().equals("true")){
            firefoxOptions.addArguments("--incognito");}
        return firefoxOptions;
    }
}
