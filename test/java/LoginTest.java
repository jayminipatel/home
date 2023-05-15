import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.logPage;

import java.util.Properties;

public class LoginTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop = new Properties();
    logPage loginPage;
    @Test(priority = 1)
    public void  openBrowser(){
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        loginPage = new logPage(driver);
        System.out.println("Login Successfully");
    }

    @Test(priority = 2)
    public  void loginTest(){
        loginPage.clickOnLoginLink();
        loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        System.out.println("login Successful");

    }

    @Test(priority = 3)
    public void closeBrowser(){

        driver.quit();
        System.out.println("Close Browser successful");
    }
}
