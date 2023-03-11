package createTransferRequest;

import baseTest.BaseTest;
import org.junit.Test;

public class CreateTransferRequestWithInvalidAmount extends BaseTest {

    @Test
    public void createTransferRequestWithInvalidAmount() {
        homePage
                .openHomePage()
                .openLoginForm()
                .fillingLoginFormWithValidCredentials()
                .checkRedirectToDashboard()
                .getHeaderElements().clickTransfersButton()
                .checkRedirectToTransferPage()
                .openTransferTab()
                .inputInvalidAmount("30000")
                .checkErrorMessageDisplayed("ви вказали суму вище 25000 грн")
          //      .checkAmountReset()
                ;

    }
}
