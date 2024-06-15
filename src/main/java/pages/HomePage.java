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

    // Examples (SignUpFrom, WebTable, ListItems, IFrames...)
    @FindBy(css = ".myhmenu > li > b > a")
    private List<WebElement> dummyControlsExamplesLinks;

    // Dictionaries options of Dummy Controls and their links
    private Map<String, WebElement> dummyControlsSelectedItens;

    public HomePage(WebDriver driver_received) {
        super();
        this.driver = driver_received;
        this.initProp();
        PageFactory.initElements(this.driver, this);
        openHomePage();
        initializeDictionaries();
    }

    public void openHomePage(){
        driver.get(properties.getProperty("driver.base-url"));
    }

    public void chooseOptionControl(String platform){
        if(dummyControlsSelectedItens.containsKey(platform.toLowerCase())){
            dummyControlsSelectedItens.get(platform.toLowerCase()).click();
        }
    }

    private void initializeDictionaries(){
        dummyControlsSelectedItens = new HashMap<String, WebElement>();
        for(WebElement linkOption : dummyControlsExamplesLinks){
            String linkText = linkOption.getText().toLowerCase();
            dummyControlsSelectedItens.put(linkText, linkOption);
        }
    }

}
