package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.HomePage;

public class HeaderElements extends CommonActionsWithElements {
    @FindBy (xpath = ".//button[@aria-label = 'login']") private WebElement buttonSignIn;
    @FindBy (xpath = ".//a[@id = 'Header_3']") private WebElement linkCatalog;
    @FindBy (xpath = ".//a[@id = 'Header_2']") private WebElement linkTransfers;



    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage clickLoginButton() {
        clickElement(buttonSignIn);
        return new HomePage(webDriver);
    }

}
