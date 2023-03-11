package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComunalPage extends ParentPage{

    @FindBy (xpath = ".//h1[contains(text(), 'Оплата комунальних послуг')]") private WebElement headerCommunalPage;
    private String companyService = ".//*[text()='%s']";

    public ComunalPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CompanyPage clickCompany(String company) {
       clickElement(webDriver.findElement(By.xpath(String.format(companyService,company))));
        return new CompanyPage(webDriver);
    }

    public ComunalPage checkRedirectToComunalPage() {

        Assert.assertTrue("Communal page is not opened", isElementDisplayed(headerCommunalPage));
        return this;

    }
}
