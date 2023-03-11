package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopUpPhonePage extends ParentPage{
    @FindBy (xpath = ".//input[@name = 'ccnumber']") private WebElement inputCCNumber;
    @FindBy (xpath = ".//input[@name = 'expdate']") private WebElement inputExpireDate;
    @FindBy (xpath = ".//input[@name = 'cvv2']") private WebElement inputCVV2;
    @FindBy (xpath = ".//button[@type = 'submit']") private WebElement buttonSubmit;
    @FindBy (xpath = ".//div[@role = 'alert']") private WebElement errorMessageExpected;
    @FindBy (xpath = ".//h1[contains(text(), ' Поповнення мобільного рахунку ')]") private WebElement headerTopUpMobile;


    public TopUpPhonePage(WebDriver webDriver) {
        super(webDriver);
    }

    public TopUpPhonePage enterCCNumber(String ccNumber){
        enterTextIntoElement(inputCCNumber, ccNumber);
        return this;
    }

    public  TopUpPhonePage enterExpireDate (String expireDate) {
        enterTextIntoElement(inputExpireDate, expireDate);
        return this;
    }

    public TopUpPhonePage enterCVV2 (String cvv2) {
        enterTextIntoElement(inputCVV2, cvv2);
        return this;
    }

    public TopUpPhonePage clickSubmitTopUpButton () {
        clickElement(buttonSubmit);
        return this;
    }

    public void checkInvalidCCNumberMessageIsDisplayed (String errorMessage) {
        Assert.assertTrue("Error message is not displayed", isElementDisplayed(errorMessageExpected));
        Assert.assertEquals("Error message is not displayed", errorMessage, errorMessageExpected.getText());
    }

    public TopUpPhonePage checkRedirectToTopUpPage() {
        Assert.assertTrue("TopUp page is not opened", isElementDisplayed(headerTopUpMobile));
        return this;
    }
}
