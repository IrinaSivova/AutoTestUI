package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;

public class LoginWithValidCredentials extends BaseTest {


    @Test
    public void validLogin(){
        homePage
                .openHomePage()
                .openLoginForm()
                .enterLoginIntoInputLogin(TestData.VALID_lOGIN)
                .enterPasswordIntoPassword(TestData.VALID_PASSWORD)
                .clickLoginButton()
                .checkRedirectToDashboard()
        ;
    }
}
