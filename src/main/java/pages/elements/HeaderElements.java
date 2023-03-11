package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;

import javax.xml.catalog.Catalog;
import java.awt.datatransfer.Transferable;

public class HeaderElements extends CommonActionsWithElements {
    @FindBy (xpath = ".//button[@aria-label = 'login']") private WebElement buttonSignIn;
    @FindBy (xpath = ".//a[@id = 'Header_3']") private WebElement linkCatalog;
    @FindBy (xpath = ".//a[@id = 'Header_2']") private WebElement linkTransfers;
    @FindBy (xpath = ".//a[@href='/dashboard']") private WebElement buttonMyCabinet;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage clickLoginButton() {
        clickElement(buttonSignIn);
        return new HomePage(webDriver);
    }

    public boolean isSignInButtonDisplayed(){
        try {
            return buttonSignIn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Dashboard clickMyCabinetButton() {
        clickElement(buttonMyCabinet);
        return new Dashboard(webDriver);
    }

    public CatalogPage clickCatalogButton() {
        clickElement(linkCatalog);
        return new CatalogPage (webDriver);
    }


    public TransferPage clickTransfersButton() {
        clickElement(linkTransfers);
        return new TransferPage(webDriver);
    }
}
