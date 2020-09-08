package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initializeWebDriver() {
        //Open the browser
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeWebDriver() {
        driver.close();
        driver.quit();
    }

    public void openPage(){
        driver.navigate().to(ProgramDataProvider.getProgramData("url"));
    }
}
