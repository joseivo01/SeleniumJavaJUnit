package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    // Examples (SignUpFrom, WebTable, ListItems, IFrames...)
    @FindBy(css = ".myhmenu > li > b > a[href='/demo/signup']")
    private WebElement signUpLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/webtable']")
    private WebElement webTableLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/listitems']")
    private WebElement listItemLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/iframes']")
    private WebElement iFramesLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/alerts']")
    private WebElement alertLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/links']")
    private WebElement linkPageLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/dragndrop']")
    private WebElement dragNDropLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/delay']")
    private WebElement delayLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/shadowDOM']")
    private WebElement shadowDOMLink;

    @FindBy(css = ".myhmenu > li > b > a[href='/demo/autosuggestion']")
    private WebElement autoSuggestionLink;

    // Dictionaries options of Dummy Controls and their links
    private Map<String, WebElement> dummyControlsSelectedItens;

    public HomePage(WebDriver driver_received) {
        super();
        this.driver = driver_received;
        this.initProp();
        PageFactory.initElements(this.driver, this);
    }

    public void openHomePage(){
        driver.get(properties.getProperty("driver.base-url"));
        ElementUtil.implicitlyWait(this.driver, 3, TimeUnit.SECONDS);
    }

    public void selectOptionPage(String page) {
        String loweCasePage = page.toLowerCase();
        if("signup form".contains(loweCasePage))
                signUpLink.click();
        else if("webtable".contains(loweCasePage))
            webTableLink.click();
        else if("listitems".contains(loweCasePage))
            listItemLink.click();
        else if("iframes".contains(loweCasePage))
            iFramesLink.click();
        else if("alerts".contains(loweCasePage))
            alertLink.click();
        else if("links".contains(loweCasePage))
            linkPageLink.click();
        else if("dragndrop".contains(loweCasePage))
            dragNDropLink.click();
        else if("delay".contains(loweCasePage))
            delayLink.click();
        else if("shadow dom".contains(loweCasePage))
            shadowDOMLink.click();
        else if("auto suggestion".contains(loweCasePage))
            autoSuggestionLink.click();
        else
            throw new IllegalArgumentException("Invalid page: " + page);
    }

}
