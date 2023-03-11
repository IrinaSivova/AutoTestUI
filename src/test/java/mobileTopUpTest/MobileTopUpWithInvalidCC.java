package mobileTopUpTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class MobileTopUpWithInvalidCC extends BaseTest {

    @Test
    public void mobileTopUpWithInvalidCC(){
        homePage
                .openHomePage()
                .enterPhoneNumberIntoPhoneNumberField("972508293")
                .enterAmount("3")
                .clickTopUpButton()
                .checkRedirectToTopUpPage()
                .enterCCNumber("11111111111")
                .enterExpireDate("07/26")
                .enterCVV2("032")
                .clickSubmitTopUpButton()
                .checkInvalidCCNumberMessageIsDisplayed("Неправильний номер картки.")
        ;
    }
}
