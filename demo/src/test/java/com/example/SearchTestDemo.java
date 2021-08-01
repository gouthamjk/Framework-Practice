package com.example;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTestDemo {   

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void startupbrowser() throws InterruptedException
    {
        // System.setProperty("webdriver.gecko.driver","C:\\Selenium\\practice\\Drivers\\geckodriver.exe");
        // driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\practice\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.pluralsight.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();    
        wait= new WebDriverWait(driver, 10);
        //wait.until(Expected Condition.title contains ());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[starts-with(@class,'ps')]")));
    //     WebDriverManager.chromedriver().setup();
    //     WebDriver driver = new ChromeDriver();
    //     driver.get("https://www.pluralsight.com/");
    //     Thread.sleep(3000);
    //     driver.quit();
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
        Thread.sleep(9000);
        WebElement skill = driver.findElement(By.xpath("//a[contains(text(),'Skill Levels')]"));
        skill.click();
        Thread.sleep(5000);
        WebElement beginner = driver.findElement(By.xpath("//span[contains(text(),'Beginner')]"));
        beginner.click();
        Thread.sleep(5000);
        WebElement roles = driver.findElement(By.xpath("//a[contains(text(),'Roles')]"));  
        roles.click();
        Thread.sleep(5000);
        WebElement softwaredevelopment = driver.findElement(By.xpath("//span[contains(text(),'Software Development')]"));
        softwaredevelopment.click();
        Thread.sleep(5000);
        // WebElement courses = driver.findElement(By.xpath("//a[contains(text(),'Courses')]"));
        WebElement courses = driver.findElement(By.linkText("Courses"));
        courses.click();
        Thread.sleep(5000);
        WebElement javacourse = driver.findElement(By.partialLinkText("Java EE"));
        javacourse.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Start a FREE 10-day trial')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Play course overview')]")).isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void closebrowser()
    {
        driver.close();
    }
}