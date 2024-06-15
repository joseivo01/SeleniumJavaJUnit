package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SignUpPage;

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
        homePage.chooseOptionControl("SignUp Form");
        signUpPage.enterFullName("Random_name");
        signUpPage.enterEmail("email_fake");
        signUpPage.enterTelephone("83838383843");
        signUpPage.uploadArchive("src/main/resources/test_pdf.pdf");
        signUpPage.selectGenderName("male");
        signUpPage.selectYearExperience("four");
        signUpPage.selectSkill("automationtesting");
        // Dado que esteja na homePage
        // E clique me "SignUp"
        // Então deve está na pagina de SignUp
    }

    @DisplayName("register an user with corrects datas")
    public void registerOneUser(String fullName, String emailValue, String telephoneValue){
        // Dado que esteja na homePage
        // E clique me "SignUp"
        // E preencha o campo FullName
        // E preencha o campo Email
        // E preencha o telephone
        // E selecione um arquivo
        // E clique no Select de Gender
        // E selecione um Gender
        // E selecione quantos anos tem de experiência
        // E selecione suas Skill
        // E selecione uma ferramenta de automação.
        // E clique no botão de "Enviar"
        // Então um alert com o texto "Registration Done!" é exibido
        // E clique em "OK"
        // E a pagina deve ser recarregada
    }

    @DisplayName("Check Tutorial Page")
    public void checkTutorialPageIsCorrect(){
        // Dado que esteja na HomePage
        // E clique em "SignUp"
        // E clique no link com nome "Tutorials"
        // Então é redirecionado para a url "https://qavalidation.com/"
    }
}
