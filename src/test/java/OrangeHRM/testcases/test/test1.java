package OrangeHRM.testcases.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.test.prequesuite.loginStep;

public class test1 extends BaseTestCase {

    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        loginStep = new loginStep(basePage);
    }

    @Test
    public void test1() {
        loginStep.login();

        takeScreenshot();
    }
    
}
