package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class CatalogPage extends ParentPage{

    @FindBy (xpath = "//div[@class='card bg-color-white-original p-20']//a[@title='Комунальні послуги']//span[text()='Комунальні послуги']") private WebElement itemComService;
    @FindBy (xpath = ".//button[@class = 'src-input-group--select-btn d-none w-100 d-lg-inline-block']") private WebElement buttonRegion;


    private String inputRegion = ".//li[contains(text(),'%s')]";

    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CatalogPage selectRegion(String region) {
        clickElement(buttonRegion);
        clickElement(String.format(inputRegion,region));
        return this;
    }

    public ComunalPage openComunalPage () {
        clickElement(itemComService);
        return new ComunalPage(webDriver);
    }


}
