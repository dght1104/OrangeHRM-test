package OrangeHRM.testcases.logout;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.annotations.TestCaseId;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.login.prerequisites.loginStep;
import OrangeHRM.testcases.logout.prerequisites.logoutStep;

public class verifyThatUserCanLogoutTheApplication extends BaseTestCase {

    private logoutStep logoutStep;
    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        logoutStep = new logoutStep(basePage);
        loginStep = new loginStep(basePage);
    }

    @Test(description = "Verify that user can logout the application successfully")
    @TestCaseId("2.1")
    public void verifyThatUserCanLogoutTheApplicationSuccessfully() {
        // Given user is logged in to the application
        loginStep.loginToTheApplication("Admin", "admin123");
        // When user clicks on the user profile icon
        logoutStep.clickUserProfileIcon();
        // And user clicks on the logout button
        logoutStep.clickLogoutButton();
        // Then verify that user is logged out successfully and login page is displayed
        loginStep.verifyThatLoginPageIsDisplayed();
        // And: take screenshot 
        takeScreenshot();
    }

}
