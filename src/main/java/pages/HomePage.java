package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElements;

public class HomePage extends ParentPage{

    @FindBy (xpath = ".//input[@id = 'form-login__input-login']") private WebElement inputLogin;
    @FindBy (xpath = ".//input[@id = 'form-login__input-password']") private WebElement inputPassword;
    @FindBy (xpath = ".//button[@id = 'form-login__button-submit']") private WebElement buttonSubmit;

    private HeaderElements headerElement = new HeaderElements(webDriver);

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public HomePage openHomePage() {
        try {
            webDriver.get(base_url);
            logger.info("Site is opened");
            return this;
        } catch (Exception e) {
            logger.error("Site can not be opened");
            Assert.fail("Site can not be opened");
            return null;
        }
    }

    public HomePage openLoginForm(){
       headerElement.clickLoginButton();
        return this;
    }

    public HomePage enterLoginIntoInputLogin(String login){
         enterTextIntoElement(inputLogin, login);
         return this;
    }

    public HomePage enterPasswordIntoPassword(String password){
        enterTextIntoElement(inputPassword, password);
        return this;

    }

    public void clickLoginButton(){
        clickElement(buttonSubmit);
    }
}
