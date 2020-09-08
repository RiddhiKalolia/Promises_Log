package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import util.Constants;
import util.ProgramDataProvider;
import util.WebDriverManager;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[text()='Log Promise']")
    private WebElement lnkLogPromise;

    @FindBy(how = How.NAME, using = "cboEmp")
    private WebElement selectFrom;

    @FindBy(how = How.ID, using = "txtPromise")
    private WebElement txtPromise;

    @FindBy(how = How.ID, using = "btnSubmit")
    private WebElement btnLogPromise;

    @FindBy(how = How.XPATH, using = "//*[text()='Promise added successfully']")
    private WebElement verifyPromiseAdded;

    public HomePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    public void addLogPromise(){
        lnkLogPromise.click();
        Select select = new Select(selectFrom);
        select.selectByVisibleText(ProgramDataProvider.getProgramData("selectfromvalue"));
        txtPromise.sendKeys(Constants.PROMISE_NAME);
        btnLogPromise.click();
        Assert.assertEquals("Promise added successfully",verifyPromiseAdded.getText());

    }
}
