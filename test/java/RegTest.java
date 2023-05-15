import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.RegPage;

import java.util.Properties;

public class RegTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop = new Properties();
    RegPage regPage;
    @Test(priority = 1)
    public void openBrowser(){
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        regPage = new RegPage(driver);
        System.out.println("Open Browser successfully");
    }
    @Test(priority = 2)
    public void register(){
        regPage.clickRegisterLink();
        regPage.registerDetails(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("dayOfBirth"),prop.getProperty("monthOfBirth"),prop.getProperty("yearOfBirth"),prop.getProperty("email"),prop.getProperty("companyName"),prop.getProperty("Password"),prop.getProperty("confirmedPassword"));
        System.out.println("Registration successful");
    }
    @Test(priority = 3)
    public void closeBrowser(){
        driver.close();
        System.out.println("Browser close successfully");
    }



}
