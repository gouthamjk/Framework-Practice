package com.example.pluralsight;
import org.openqa.selenium.WebDriver;
import static com.example.pluralsight.DriverFactory.getChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;

public class CommonVerification{

    protected WebDriver driver = getChromeDriver();

    private CommonVerification()
    {

    }
    public static CommonVerification getCommonVerification()
    {
        return new CommonVerification();
    }
  

    public CommonVerification verifyIsDisplayed(By element)
    {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
        return this;
    }

}