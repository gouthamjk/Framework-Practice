package com.example.pluralsight;
import static com.example.pluralsight.DriverFactory.getChromeDriver;
import static com.example.pluralsight.DriverFactory.getWebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getWebDriverWait();

    private SearchPage()
    {

    }

    public static SearchPage getSearchPage()
    {
        return new SearchPage();
    }

    public SearchPage filterBySkillLevel(SkillLevel value) throws InterruptedException
    {
        WebElement skill = driver.findElement(By.xpath("//a[contains(text(),'Skill Levels')]"));
        skill.click();
        Thread.sleep(5000);
        WebElement skillselect = driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]"));
        skillselect.click();
        Thread.sleep(5000);
        return this;
    }
    public SearchPage filterByRole(Role role) throws InterruptedException
    {
        WebElement roles = driver.findElement(By.xpath("//a[contains(text(),'Roles')]"));  
        roles.click();
        Thread.sleep(5000);
        WebElement roleselect = driver.findElement(By.xpath("//span[contains(text(),'"+role+"')]"));
        roleselect.click();
        Thread.sleep(5000);
        return this;
    }
    public SearchPage selectTabCourse() throws InterruptedException
    {
        WebElement courses = driver.findElement(By.linkText("Courses"));
        courses.click();
        Thread.sleep(5000);
        return this;
    }
    public void selectCourse() throws InterruptedException
    {
        WebElement javacourse = driver.findElement(By.partialLinkText("Java EE"));
        javacourse.click();
        Thread.sleep(5000);
    }
    
}
