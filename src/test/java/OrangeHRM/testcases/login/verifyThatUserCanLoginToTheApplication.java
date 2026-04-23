package OrangeHRM.testcases.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.OrangeHRM.annotations.TestCaseId;
import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.login.prerequisites.loginStep;

public class verifyThatUserCanLoginToTheApplication extends BaseTestCase {

    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        loginStep = new loginStep(basePage);
    }

    @Test(description = "Verify that user can login to the application with valid credentials")
    @TestCaseId("1.1")
    public void verifyThatUserCanLoginToTheApplicationWithValidCredentials() {
        // Given user is on the login page
        loginStep.navigateToLoginPage();
        // When user enters valid username and password
        loginStep.enterUsernameAndPassword("Admin", "admin123");
        // And clicks on the login button
        loginStep.clickLoginButton();
        // Then user should be logged in successfully
        loginStep.verifyUserIsLoggedIn();
        // Take a screenshot after successful login
        takeScreenshot();
    }

    @Test(description = "Verify that user cannot login to the application with invalid credentials")
    @TestCaseId("1.2")
    public void verifyThatUserCanNotLoginToTheApplicationWithInvalidCredentials() {
        // Given user is on the login page
        loginStep.navigateToLoginPage();
        // When user enters invalid username and password
        loginStep.enterUsernameAndPassword("Admin", "invalidpassword");
        // And clicks on the login button
        loginStep.clickLoginButton();
        // Then user should not be logged in
        loginStep.verifyUserIsNotLoggedIn();
        // Take a screenshot after failed login attempt
        takeScreenshot();
    }
    
}
