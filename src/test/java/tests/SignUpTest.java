package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.ElementUtil;

import java.util.concurrent.TimeUnit;

public class SignUpTest extends BaseTest {
    private static HomePage homePage;
    private static SignUpPage signUpPage;

    @BeforeAll
    public static void initialization(){
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    @DisplayName("Accessing SignUp Page")
    public void accessSigUpPage(){
        homePage.openHomePage();
        homePage.selectOptionPage("SignUp Form");
        Assertions.assertEquals("https://qavbox.github.io/demo/signup/",homePage.driver.getCurrentUrl());
    }

    // After add faker library
    @Test
    @DisplayName("register an user with corrects datas")
    public void registerOneUser(){
        System.out.println("ENTREI NO SEGUNDO -------------------------------------------------------------------");
        homePage.openHomePage();
        homePage.selectOptionPage("SignUp Form");
        signUpPage.enterFullName("Random_name");
        signUpPage.enterEmail("email_fake");
        signUpPage.enterTelephone("83838383843");
        signUpPage.uploadArchive("src/main/resources/test_pdf.pdf");
        signUpPage.selectGenderName("male");
        signUpPage.selectYearExperience("four");
        signUpPage.selectSkill("automationtesting");
        signUpPage.selectAutomation("cypress");
        signUpPage.clickOnSendButton();
        Assertions.assertTrue(signUpPage.textOnAlert().contains("Registration Done!"));
    }

    @DisplayName("Check Tutorial Page")
    public void checkTutorialPageIsCorrect(){
        // Dado que esteja na HomePage
        // E clique em "SignUp"
        // E clique no link com nome "Tutorials"
        // Então é redirecionado para a url "https://qavalidation.com/"
    }
}
