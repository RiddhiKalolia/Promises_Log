package testcase;

import org.testng.annotations.*;
import util.WebDriverManager;

public class BaseTestCase {
    protected WebDriverManager webDriverManager;


    @BeforeSuite
    protected void initializeBrowser() {
        //Open the browser
        webDriverManager = new WebDriverManager();
        webDriverManager.initializeWebDriver();
    }

    @AfterSuite
    protected void closeBrowser() {
       webDriverManager.closeWebDriver();
    }

    protected void openLandingPage() {
        webDriverManager.openPage();
    }
}
