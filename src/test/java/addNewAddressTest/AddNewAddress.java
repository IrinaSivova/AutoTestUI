package addNewAddressTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ParentPage;

public class AddNewAddress extends BaseTest {

    @Test
    public void addNewAddress(){
        homePage
                .openHomePage()
                .openLoginForm()
                .fillingLoginFormWithValidCredentials()
                .checkRedirectToDashboard()
                .openAddAddressForm()
                .enterAddressName("Мій дім")
                .enterAddressRegion("м. Черкаси та область")
                .enterAddressCity("м. Черкаси")
                .enterAddressStreet("вулиця Смілянська")
                .enterAddressBuilding(TestData.BUILDING)
                .enterAddressAppt(TestData.APPT)
                .clickSubmitNewAddressButton()
                .isAddressAdded()
                ;

    }

    @After
    public void deleteAddress (){
        homePage
                .openHomePage()
                .getHeaderElement().clickMyCabinetButton()
                .checkRedirectToDashboard()
                .deleteAddressWithTitleTillPresent("Мій дім")

        ;



        ;

    }

}
