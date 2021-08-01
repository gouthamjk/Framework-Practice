package com.example;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static com.example.pluralsight.DriverFactory.getChromeDriver;
import static com.example.pluralsight.DriverFactory.getWebDriverWait;
public class BaseTestClass {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void startupbrowser()
    {
        //System.setProperty("webdriver.gecko.driver","C:\\Selenium\\practice\\Drivers\\geckodriver.exe");
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","C:\\Selenium\\practice\\Drivers\\chromedriver.exe");
        driver = getChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();    
        wait = getWebDriverWait();
    }

    @BeforeMethod
    public void goToHome()
    {
        driver.get("https://www.pluralsight.com/");
    }
    @AfterSuite(alwaysRun = true)
    public void closebrowser()
    {
        driver.close();
    }
}
