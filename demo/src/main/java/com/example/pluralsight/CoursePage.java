package com.example.pluralsight;
import static com.example.pluralsight.DriverFactory.getChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage {
    private WebDriver driver = getChromeDriver();

    private CoursePage()
    {

    }
    public static CoursePage getCoursePage()
    {
        return new CoursePage();
    }
    // public CoursePage verifyFreeTrialIsDisplay()
    // {
    //     Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Start a FREE 10-day trial')]")).isDisplayed());
    //     return this;
    // }
    // public CoursePage verifyCoursePreviewIsDisplay()
    // {
    //     Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Play course overview')]")).isDisplayed());
    //     return this;
    // }

    // public CoursePage verifyIsDisplayed(By element)
    // {
    //     Assert.assertTrue(driver.findElement(element).isDisplayed());
    //     return this;
    // }

    public static By freeTrialButton()
    {
        return By.xpath("//a[contains(text(),'Start a FREE 10-day trial')]");
    }
    public static By coursePreviewButton()
    {
        return By.xpath("//a[contains(text(),'Play course overview')]");
    }
}
