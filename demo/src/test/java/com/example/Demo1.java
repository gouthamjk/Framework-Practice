package com.example;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Demo1 {
    
WebDriver driver;
WebDriverWait wait;

@BeforeMethod
public void startupbrowser()
{
    System.setProperty("webdriver.gecko.driver","C:\\Selenium\\practice\\Drivers\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.get("https://www.pluralsight.com/courses/java-ee-7-fundamentals");
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.manage().window().maximize();    
    wait= new WebDriverWait(driver, 10);
}
@Test
public void assertmethod() throws InterruptedException
{
    //// WebElement clickelement = driver.findElement(By.partialLinkText("Start a"));
   // WebElement clickelement = driver.findElement(By.xpath("//a[contains(text(),'Start a FREE 10-day trial')]"));
   // clickelement.click();
    //Thread.sleep(3000);
    //driver.navigate().back();
    //Thread.sleep(3000);
    //WebElement clickelement1 = driver.findElement(By.xpath("//a[contains(text(),'Play course overview')]"));
   // clickelement1.click();
    
   Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Start a FREE 10-day trial')]")).isDisplayed());
   Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Play course overview')]")).isDisplayed());
    // Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Play course overview')]")).isDisplayed());
}
}