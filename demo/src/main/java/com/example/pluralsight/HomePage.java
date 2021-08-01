package com.example.pluralsight;
import static com.example.pluralsight.DriverFactory.getChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
    private WebDriver driver = getChromeDriver();

    private HomePage()
    {

    }
    public static HomePage getHomePage()
    {
        return new HomePage();
    }
    public void search(String value) throws InterruptedException
    {
        WebElement Search =driver.findElement(By.xpath("//li//a[starts-with(@class,'ps')]"));
        Search.click();
        Thread.sleep(3000);
        WebElement search =driver.findElement(By.className("header_search--input"));
        Thread.sleep(3000);
        search.sendKeys(value);
        search.sendKeys(Keys.ENTER);
    }
}