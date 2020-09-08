package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.WebDriverManager;

public class LogoutPage extends BasePage {

    @FindBy(how = How.XPATH, using="//a[@href='../logout.php']")
    private WebElement lnkLogout;

    public LogoutPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    public void clickLogout(){
        lnkLogout.click();
    }
}
