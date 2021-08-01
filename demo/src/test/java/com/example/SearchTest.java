package com.example;
import com.example.pluralsight.CoursePage;
import com.example.pluralsight.HomePage;
import com.example.pluralsight.Role;
import com.example.pluralsight.SearchPage;
import com.example.pluralsight.CommonVerification;
import com.example.pluralsight.SkillLevel;
import org.testng.annotations.Test;
import static com.example.pluralsight.CommonVerification.getCommonVerification;
//import static com.example.pluralsight.HomePage.getHomePage;
import static com.example.pluralsight.SearchPage.getSearchPage;
import static com.example.pluralsight.CoursePage.getCoursePage;
//import static com.example.pluralsight.CoursePage.*;
public class SearchTest extends BaseTestClass{   
    HomePage home = HomePage.getHomePage();
    SearchPage search = getSearchPage();
    CoursePage course = getCoursePage();
    CommonVerification common = getCommonVerification();
    @Test
    public void basicfilterbytest() throws InterruptedException
    { 
        home.search("Java");
        Thread.sleep(9000);

        search.filterBySkillLevel(SkillLevel.BEGINNER)
              .filterByRole(Role.SOFTWARE_DEVELOPMENT)
              .selectTabCourse()
              .selectCourse();

        // course.verifyFreeTrialIsDisplay()
        //       .verifyCoursePreviewIsDisplay();  
        // course.verifyIsDisplayed(freeTrialButton())
        //       .verifyIsDisplayed(coursePreviewButton());
        common.verifyIsDisplayed(CoursePage.freeTrialButton())
              .verifyIsDisplayed(CoursePage.coursePreviewButton());
    }  
}