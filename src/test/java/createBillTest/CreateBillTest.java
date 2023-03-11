package createBillTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CreateBillTest extends BaseTest {

    @Test
    public void createBillTest () {

    homePage
            .openHomePage()
            .openLoginForm()
            .fillingLoginFormWithValidCredentials()
            .checkRedirectToDashboard()
            .getHeaderElements().clickCatalogButton()
            .selectRegion ("Черкаси та обл.")
            .openComunalPage()
            .checkRedirectToComunalPage()
            .clickCompany ("КП \"Черкасиводоканал\"")
            .checkRedirectToCompanyPage("КП \"Черкасиводоканал\"")
            .enterAccountNumber("40453081")
            .clickCreateBillButton()
            .checkBillIsAddedWithTitle("КП \"Черкасиводоканал\"")
    ;
    }
}
