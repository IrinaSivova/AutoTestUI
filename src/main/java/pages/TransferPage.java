package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferPage extends ParentPage{

    @FindBy(xpath = "//div[@class='row']//a[@href='/r3/otrymaty-koshty-na-kartku']") private WebElement buttonTransfer;
    @FindBy (xpath = "//h1[contains(text() ,'Перекази грошей з картки на картку Visa/Mastercard та Простір')]") private WebElement titleTransfer;
    @FindBy (xpath = "//input[@id='bill_amount']") private WebElement inputAmount;
    @FindBy (xpath = "//div[@class='alert alert-error']") private WebElement errorMessage;

    public TransferPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TransferPage openTransferTab () {
        clickElement(buttonTransfer);
        return this;
    }

    public TransferPage checkRedirectToTransferPage() {
        Assert.assertTrue("Transfer page is not opened", isElementDisplayed(titleTransfer));
        return this;
    }

    public TransferPage inputInvalidAmount(String amount) {
        enterTextIntoElement(inputAmount, amount);
        return this;
    }


    public TransferPage checkErrorMessageDisplayed(String expectedErrorMessage) {
        Assert.assertEquals("Error message is not displayed", expectedErrorMessage, errorMessage.getText() );
        return this;
    }


    public TransferPage checkAmountReset() {
        Assert.assertEquals("Amount is not reset", "25000", inputAmount.getText());
        return this;
    }
}
