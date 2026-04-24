package OrangeHRM.testcases.employee;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.employee.prerequisites.employeeStep;
import OrangeHRM.testcases.login.prerequisites.loginStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test extends BaseTestCase {
    private employeeStep employeeStep;
    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        employeeStep = new employeeStep(basePage);
        loginStep = new loginStep(basePage);
    }

    @Test
    public void verifyEmployeePage() {
        loginStep.loginToTheApplication("Admin", "admin123");
        employeeStep.navigateToEmployeePage();
        employeeStep.navigateToAddEmployeePage();
    }
}
