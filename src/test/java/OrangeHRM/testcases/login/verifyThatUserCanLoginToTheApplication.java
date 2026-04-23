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

    @Test
    @TestCaseId("TC-001")
    public void verifyThatUserCanLoginToTheApplication() {
        loginStep.navigateToLoginPage();
        takeScreenshot();
        takeScreenshot();
    }
    
}
