package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import util.Constants;
import util.ProgramDataProvider;
import util.WebDriverManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchPage extends BasePage {

    @FindBy(how = How.NAME, using = "cboEmp")
    private WebElement selectPromiser;

    @FindBy(how = How.NAME, using="btnSearch")
    private WebElement btnSearch;

    @FindBy(how=How.ID,using="txtStartDate")
    private WebElement setStartDate;

    @FindBy(how = How.XPATH, using="(//td[text()='Sonali test'])[1]")
    private WebElement tdPromiseFormGrid;


    private WebElement tdPromiseGrid;

    public SearchPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    public WebElement getTdPromiseGrid() {
        return tdPromiseGrid;
    }

    public void setTdPromiseGrid() {
        this.tdPromiseGrid = webDriverManager.getDriver().findElement(By.xpath("//td[text()='"+Constants.PROMISE_NAME+"']"));
    }

    public void searchPromise(){
        Select selectPromise = new Select(selectPromiser);
        selectPromise.selectByVisibleText(ProgramDataProvider.getProgramData("selectfromvalue"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        setStartDate.sendKeys(formatter.format(date));
        btnSearch.click();
    }
    public void verifyPromise(){
        Assert.assertEquals("Sonali test", tdPromiseFormGrid.getText());
        setTdPromiseGrid();
        Assert.assertEquals(Constants.PROMISE_NAME,tdPromiseGrid.getText());
    }
}
