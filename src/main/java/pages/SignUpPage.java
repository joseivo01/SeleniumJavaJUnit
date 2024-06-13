package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class SignUpPage extends BasePage {
    private final WebDriver driver;

    @FindBy(css = "#username")
    private WebElement fullNameInput;

    @FindBy(css = "#email")
    private WebElement emailInput;

    @FindBy(css = "#tel")
    private WebElement telephoneInput;

    @FindBy(css = "#fax")
    private WebElement faxNumberInput;

    @FindBy(css = "input[multiple='multiple']")
    private WebElement uploadInput;

    @FindBy(css = "select[name='sgender']")
    private WebElement selectGender;

    @FindBy(css = "input[name='experience']")
    private List<WebElement> optionsYearExperience;

    @FindBy(css = "input[name='language']")
    private List<WebElement> optionsLanguage;

    @FindBy(css = "#tools")
    private WebElement selectAutomationTool;

    @FindBy(css = "div.linesubmit > input[onclick='MySubmit()']")
    private WebElement sendButton;

    public SignUpPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String fullName){
        fullNameInput.sendKeys(fullName);
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone){
        telephoneInput.sendKeys(telephone);
    }

    public boolean checkFaxInputIsDisabled() {
        // return true as string
        String disabledAttribute = faxNumberInput.getAttribute("disabled");

        // convert true string to true boolean
        return Boolean.parseBoolean(disabledAttribute);
    }

    public void uploadArchive(String pathFile){
        File fileUpload = new File(pathFile);
        uploadInput.sendKeys(fileUpload.getAbsolutePath());
    }

    public void selectGenderName(String genderName){
        Select selectedGenderNameElement = new Select(selectGender);
        selectedGenderNameElement.selectByValue(genderName.toLowerCase());
    }

    public void selectYearExperience(String yearExSelected) {
        for (WebElement year : optionsYearExperience) {
            String yearValue = year.getAttribute("value");
            if (yearValue != null && yearValue.equalsIgnoreCase(yearExSelected)) {
                year.click();
                break; // Stop iteração after found element
            }
        }
    }

    public void selectSkill(String skillSelected) {
        for (WebElement language : optionsLanguage) {
            String languageValue = language.getAttribute("value");
            if (languageValue != null && languageValue.replaceAll("\\s+", "").equalsIgnoreCase(skillSelected)) {
                language.click();
                break; // Stop the iteration after finding the element
            }
        }
    }

    public void selectAutomation(String automationToolSelected){
        Select selectedTool = new Select(selectAutomationTool);
        selectedTool.selectByValue(automationToolSelected.toLowerCase());
    }

    public void clickOnSendButton(){
        sendButton.click();
    }

}
