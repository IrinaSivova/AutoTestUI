package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElements;

public class BillsPage extends ParentPage{
    @FindBy (xpath = ".//span[@class='address-name-title']") private WebElement titleAddress;
    @FindBy (xpath = ".//div[@class='toast__list']") private WebElement successMessage;

    HeaderElements headerElements = new HeaderElements(webDriver);


    public BillsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElements getHeaderElements() {
        return headerElements;
    }

    public BillsPage isAddressAdded (){
        Assert.assertEquals("Address is not added", "Мій дім", titleAddress.getText());
        Assert.assertEquals("No Success message is shown", "Нова адреса успішно створена! Ви можете додати рахунки", successMessage.getText());
        return this;
    }

}
