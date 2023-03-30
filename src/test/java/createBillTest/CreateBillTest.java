package createBillTest;

import baseTest.BaseTest;
import org.junit.After;
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
            .enterAccountNumber("11111")
            .clickCreateBillButton()
            .checkBillIsAddedWithTitle("КП \"Черкасиводоканал\"")
    ;
    }

    @After
    public void deleteBill () {
        homePage
                .openHomePage()
                .getHeaderElement().clickMyCabinetButton()
                .deleteBills("КП \"Черкасиводоканал\"")
                ;
    }


}
