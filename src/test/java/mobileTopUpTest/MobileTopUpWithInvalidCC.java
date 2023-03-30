package mobileTopUpTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class MobileTopUpWithInvalidCC extends BaseTest {

    @Test
    public void mobileTopUpWithInvalidCC(){
        homePage
                .openHomePage()
                .enterPhoneNumberIntoPhoneNumberField("2222222")
                .enterAmount("3")
                .clickTopUpButton()
                .checkRedirectToTopUpPage()
                .enterCCNumber("11111111111")
                .enterExpireDate("22/24")
                .enterCVV2("000")
                .clickSubmitTopUpButton()
                .checkInvalidCCNumberMessageIsDisplayed("Неправильний номер картки.")
        ;
    }
}
