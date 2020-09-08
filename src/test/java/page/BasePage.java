package page;

import org.openqa.selenium.support.PageFactory;
import util.WebDriverManager;

public class BasePage {
   protected WebDriverManager webDriverManager;

    public BasePage(WebDriverManager webDriverManager) {
        PageFactory.initElements(webDriverManager.getDriver(), this);
        this.webDriverManager = webDriverManager;
    }
}
