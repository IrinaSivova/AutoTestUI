package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParentPage extends CommonActionsWithElements{
    protected String base_url;
    @FindBy (xpath = ".//button[@class='btn btn-m btn-close ml-8']") private WebElement buttonCancelCookies;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        base_url = configProperties.base_url();
    }

  public boolean isCookiesDialogDisplayed() {
      return isElementDisplayed(buttonCancelCookies);
  }

  public void dismissCookies() {
      if(isCookiesDialogDisplayed()) {
          clickElement(buttonCancelCookies);
      }
  }

}
