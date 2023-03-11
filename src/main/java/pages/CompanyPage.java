package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends ParentPage{
    @FindBy (xpath = ".//input[@name='request[contract_number]']") private WebElement inputAccountNumber;
    @FindBy (xpath = ".//button[@type='submit']") private WebElement buttonCreateBillButton;

    private String titlePage = ".//h1[contains(text(),'%s')]";

    public CompanyPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CompanyPage checkRedirectToCompanyPage (String companytitle){
        Assert.assertTrue("The company page is not opened", isElementDisplayed(webDriver.findElement(By.xpath(String.format(titlePage,companytitle)))));
        return this;
    }

    public CompanyPage enterAccountNumber(String accountNumber) {
        enterTextIntoElement(inputAccountNumber,accountNumber);
        return this;
    }

    public Dashboard clickCreateBillButton() {
        clickElement(buttonCreateBillButton);
        return new Dashboard(webDriver);

    }
}
