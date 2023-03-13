package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderElements;

import java.util.List;

public class Dashboard extends ParentPage{
    @FindBy (xpath = "//h1[contains(text(), 'Мій кабінет')]") private WebElement titleMyCabinet;
    @FindBy (xpath = ".//span[text() = 'Нова адреса']") private WebElement buttonAddNewAddress;
    @FindBy (xpath = ".//input[@id = 'asf_0']") private WebElement inputAddressName;
    @FindBy (xpath = ".//input[@id = 'asf_1']") private WebElement inputRegion;
    @FindBy (xpath = ".//input[@id = 'asf_2']") private WebElement inputCity;
    @FindBy (xpath = ".//input[@id = 'asf_3']") private WebElement inputStreet;
    @FindBy (xpath = ".//input[@id = 'asf_4']") private WebElement inputBuilding;
    @FindBy (xpath = ".//input[@id = 'asf_5']") private WebElement inputAppt;
    @FindBy (xpath = ".//button[@type= 'submit']") private WebElement buttonSubmitAddress;
    @FindBy (xpath = ".//span[@class='subtitle-2 mb-0 title-ellipsis']") private WebElement titleAddress;
    @FindBy (xpath = ".//button[@class='list-item__actions-toggle c-pointer']") private WebElement buttonAction;
    @FindBy (xpath = ".//span[text()='Видалити адресу']") private WebElement buttonDelete;
    @FindBy (xpath = ".//button[@class='btn btn-primary w-100']") private WebElement buttonConfirmDelete;
    @FindBy (xpath = ".//div[@class='toast__list']") private WebElement successDeleteAddressMessage;
    @FindBy (xpath = "//div[@id='table-bills-id']//button[@class='list-item__actions-toggle c-pointer']") private WebElement buttonActionBills;
    @FindBy (xpath = "//span[text()='Видалити рахунок']") private WebElement buttonDeleteBill;
    @FindBy (xpath = "//button[@class='btn btn-primary w-168']") private WebElement buttonConfirmDeleteBill;


    private String titleAddedAddress = ".//*[text()='%s']";
    private String titleAddedBill = ".//*[text()='%s']" ;
    private String titleBill = ".//*[text()='%s']";


    HeaderElements headerElements = new HeaderElements(webDriver);
    public Dashboard(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElements getHeaderElements() {
        return headerElements;
    }

    public Dashboard checkRedirectToDashboard () {
        dismissCookies();
        Assert.assertTrue("User is not logged in", isElementDisplayed(titleMyCabinet));
        Assert.assertFalse("User is not logged in", headerElements.isSignInButtonDisplayed());
        return this;
    }

    public Dashboard openAddAddressForm(){
        clickElement(buttonAddNewAddress);
        return this;
    }

    public Dashboard enterAddressName(String name){

        enterTextIntoElement(inputAddressName, name);
        return this;
    }

    public Dashboard enterAddressRegion(String region){

        enterTextIntoElement(inputRegion, region);
        return this;
    }

    public Dashboard enterAddressCity(String city){

        enterTextIntoElement(inputCity, city);

        return this;
    }

    public Dashboard enterAddressStreet(String street){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        enterTextIntoElement(inputStreet, street);

        return this;
    }

    public Dashboard enterAddressBuilding(String numberBuilding){

        enterTextIntoElement(inputBuilding, numberBuilding);

        return  this;
    }

    public Dashboard enterAddressAppt(String appt){

        enterTextIntoElement(inputAppt, appt);
        return this;
    }

    public BillsPage clickSubmitNewAddressButton(){
        clickElement(buttonSubmitAddress);
        return new BillsPage(webDriver);
    }


    public List<WebElement> getAddressesWithTitle(String title){
        return webDriver.findElements(
                By.xpath(String.format(titleAddedAddress,title)));
    }


    public Dashboard deleteAddressWithTitleTillPresent(String titleOfAddedAddress) {
        List<WebElement> listOfAddresses = getAddressesWithTitle(titleOfAddedAddress);
        int counter = listOfAddresses.size();
        while (!listOfAddresses.isEmpty() && counter>0){
            clickElement(buttonAction);
            clickElement(buttonDelete);
            clickElement(buttonConfirmDelete);

            logger.info("Address was deleted with title "+ titleOfAddedAddress);
            webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(String.format(titleAddedAddress, titleOfAddedAddress)),counter-1));
            listOfAddresses = getAddressesWithTitle(titleOfAddedAddress);
            counter--; // counter = counter - 1
        }
        if (listOfAddresses.size() ==  0) {
            logger.info("All addresses were deleted with title " + titleOfAddedAddress);
        } else {
            logger.error("Delete fail");
            Assert.fail("Delete fail");
        }
        return this;
    }

    public List<WebElement> getBillsWithTitle(String title){
        return webDriver.findElements(
                By.xpath(String.format(titleAddedBill,title)));
    }

    public void checkBillIsAddedWithTitle (String title) {
        Assert.assertEquals("Bill is not added", 1, getBillsWithTitle(title).size());
    }


    public Dashboard deleteBills(String titleOfBill) {
            List<WebElement> listOfBills = getBillsWithTitle(titleOfBill);
            int counter = listOfBills.size();
            while (!listOfBills.isEmpty() && counter>0){
                scroll(buttonActionBills);
                clickElement(buttonActionBills);
                clickElement(buttonDeleteBill);
                clickElement(buttonConfirmDeleteBill);

                logger.info("Bill was deleted with title "+ titleOfBill);
                webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(String.format(titleBill, titleOfBill)),counter-1));
                listOfBills = getAddressesWithTitle(titleOfBill);
                counter--; // counter = counter - 1
            }
            if (listOfBills.size() ==  0) {
                logger.info("All bills were deleted with title " + titleOfBill);
            } else {
                logger.error("Delete fail");
                Assert.fail("Delete fail");
            }
            return this;
    }
}
