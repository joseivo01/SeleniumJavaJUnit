package tests;

import base.BasePage;
import base.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import pages.HomePage;
import pages.SignUpPage;

public class SigUpTest extends BaseTest {
    HomePage homePage;
    SignUpPage signUpPage;

    @BeforeAll
    public void initialization(){
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @DisplayName("register an user")
    public void registerOneUser(String fullName, String emailValue, String telephoneValue){}


}
