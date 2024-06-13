package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage{
    private final WebDriver driver;

    // Examples (SignUpFrom, WebTable, ListItems, IFrames...)
    @FindBy(css = ".myhmenu > li > b > a")
    private List<WebElement> dummyControlsExamplesLinks;

    // Dictionaries options of Dummy Controls and their links
    private Map<String, WebElement> dummyControlsExamplesPlatform;

    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        // Created to initiate all selectors that use @FindBy, without this not works!
        PageFactory.initElements(driver, this);
        initializeDictionaries();
    }

    public void openHomePage(){
        driver.navigate().to(properties.getProperty("driver.base-url"));
    }

    public void choosePlatform(String platform){
        if(dummyControlsExamplesPlatform.containsKey(platform.toLowerCase())){
            dummyControlsExamplesPlatform.get(platform.toLowerCase()).click();
        }
    }

    public void initializeDictionaries(){
        dummyControlsExamplesPlatform = new HashMap<String, WebElement>();
        for(WebElement linkOption : dummyControlsExamplesLinks){
            dummyControlsExamplesPlatform.put(linkOption.getText().toLowerCase(), linkOption);
        }
    }

    // Is only to no give any erros
    public void setDummyControlsExamplesLinks(List<WebElement> localDummyControlsExamplesLinks) {
        this.dummyControlsExamplesLinks = localDummyControlsExamplesLinks;
    }
}
