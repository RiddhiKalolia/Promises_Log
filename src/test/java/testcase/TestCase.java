package testcase;

import org.testng.Reporter;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.LogoutPage;
import page.SearchPage;
import util.ProgramDataProvider;

public class TestCase extends BaseTestCase{
    @Test(priority = 0)
    public void verifyIncorrectLogin() {
        LoginPage page = new LoginPage(webDriverManager);
        super.openLandingPage();
        page.doLogin();
        page.verifyValidation();
        Reporter.log("Login validation successfully.");
    }

    @Test(priority = 1)
    public void verifyLogin() {
        LoginPage page = new LoginPage(webDriverManager);
        super.openLandingPage();
        page.setCredentials(ProgramDataProvider.getProgramData("username"),
                ProgramDataProvider.getProgramData("password"));
        page.doLogin();
        Reporter.log("Login successfully.");
    }
    @Test(priority = 2)
    public void addPromise() {
        HomePage page = new HomePage(webDriverManager);
        page.addLogPromise();
        Reporter.log("Add Promise successfully.");
    }

    @Test(priority = 3)
    private void searchPromise(){
        SearchPage page = new SearchPage(webDriverManager);
        page.searchPromise();
        Reporter.log("Search Promise successfully.");
        page.verifyPromise();
        Reporter.log("Verify Search Promise successfully.");
    }

    @Test(priority = 4)
    public void verifyLogout()  {
        LogoutPage page = new LogoutPage(webDriverManager);
        page.clickLogout();
        Reporter.log("Logout successfully.");
    }
}
