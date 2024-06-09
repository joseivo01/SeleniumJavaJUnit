package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class HomePage extends BasePage{
    private WebDriver driver;

    // JavaScript examples (Backbone.js, AngularJs, Vue.js, ..)
    @FindBy(css = "iron-pages.app-lists > div:nth-child(1) li")
    private List<WebElement> jsExamplesLinks;

    // Examples in programming languages that compile to JavaScript (Kotlin+React, Spine, Dart, ..)
    @FindBy(css = "iron-pages.app-lists > div:nth-child(2) li")
    private List<WebElement> compiledToJsExamplesLinks;

    // Examples that are still in the evaluation stage (DUEL, Dijon, ..)
    @FindBy(css = "iron-pages.app-lists > div:nth-child(3) li")
    private List<WebElement> underEvaluationExamplesLinks;

    // Dictionaries of platforms and their links
    private Map<String, WebElement> jsExamplesPlatforms;
    private Map<String, WebElement> compiledToJsExamplesPlatforms;
    private Map<String, WebElement> underEvaluationExamplesPlatforms;

    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        // Created to initiate all selectors that use @FindBy, without this not works!
        PageFactory.initElements(driver, this);
        // Continues After!
        // initializeDictionaries();
    }

}
