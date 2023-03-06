package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage extends CommonActionsWithElements{
    protected String base_url;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        base_url = configProperties.base_url();
    }
}
