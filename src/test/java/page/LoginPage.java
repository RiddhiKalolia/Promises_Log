package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import util.WebDriverManager;

public class LoginPage extends BasePage {

    @FindBy(how = How.NAME, using = "txtUsername")
    private WebElement txtUserName;

    @FindBy(how = How.XPATH, using = "//input[@name='txtPassword']")
    private WebElement txtPassword;

    @FindBy(how = How.NAME, using = "submit1")
    private WebElement btnLogin;

    @FindBy(how = How.XPATH, using="//*[text()='Invalid Username/password']")
    private WebElement msgvalidation;

    public LoginPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    public void setCredentials(String userName, String password){
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }
    public void doLogin() {
        btnLogin.click();
    }

    public void verifyValidation(){
        Assert.assertEquals("Invalid Username/password",msgvalidation.getText());
    }

}
