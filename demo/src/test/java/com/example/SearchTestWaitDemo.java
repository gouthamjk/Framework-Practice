package com.example;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTestWaitDemo {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void startupbrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\practice\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.pluralsight.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();    
        wait= new WebDriverWait(driver, 10);
    }
    @Test
    public void basicfilterbytest() throws InterruptedException
    {
        WebElement Search =driver.findElement(By.xpath("//li//a[starts-with(@class,'ps')]"));
        Search.click();
        Thread.sleep(3000);
        WebElement search =driver.findElement(By.className("header_search--input"));
        Thread.sleep(3000);
        search.sendKeys("Java");
        search.sendKeys(Keys.ENTER); 
        Thread.sleep(5000);
        WebElement skill = driver.findElement(By.xpath("//a[contains(text(),'Skill Levels')]"));
        skill.click();
        Thread.sleep(5000);
        // WebElement filter = driver.findElement(By.xpath("div//[contains(@class,'search-filter-header') and contains(.,'Skill Levels'))]"));
        // WebElement filter = driver.findElement(By.linkText("Skill Levels"));
        // WebElement filter = driver.findElement(By.className("open"));
        // WebElement filter1 = driver.findElement(By.cssSelector(".open"));
        // WebElement beginner = driver.findElement(By.linkText("Beginner"));
        Thread.sleep(5000);
        WebElement beginner = driver.findElement(By.xpath("//span[contains(text(),'Beginner')]"));
        beginner.click();
        Thread.sleep(5000);
        WebElement roles = driver.findElement(By.xpath("//a[contains(text(),'Roles')]"));  
        roles.click();
        Thread.sleep(5000);
        WebElement softwaredevelopment = driver.findElement(By.xpath("//span[contains(text(),'Software Development')]"));
        softwaredevelopment.click();
    }

    // @AfterMethod(alwaysRun = true)
    // public void closebrowser()
    // {
    //     driver.close();
    // }
}