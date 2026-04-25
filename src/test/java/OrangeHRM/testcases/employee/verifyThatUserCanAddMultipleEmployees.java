package OrangeHRM.testcases.employee;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.employee.prerequisites.employeeStep;
import OrangeHRM.testcases.login.prerequisites.loginStep;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.annotations.TestCaseId;

public class verifyThatUserCanAddMultipleEmployees extends BaseTestCase {
    private employeeStep employeeStep;
    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        employeeStep = new employeeStep(basePage);
        loginStep = new loginStep(basePage);
        // When the user logs in to the application
        loginStep.loginToTheApplication("Admin", "admin123");
        // And the user navigates to the Employee page
        employeeStep.navigateToEmployeePage();
    }

    // ===== data =====
    @DataProvider(name = "employees")
    public Object[][] getEmployees() {
        return new Object[][] {
                { "John", "Ramsay", "Doe" },
                { "Jane", "Marie", "Smith" },
                { "Alex", "Brown", "Johnson" }
        };
    }

    @Test(description = "Verify that user can add multiple employees", dataProvider = "employees")
    @TestCaseId("3.2")
    public void verifyThatUserCanAddMultipleEmployees(String first, String middle, String last) {
        // And the user clicks on the Add Employee button
        employeeStep.navigateToAddEmployeePage();
        // And the user fills in the employee details
        employeeStep.addEmployee(first, middle, last);
        // And gets the employee id
        String employeeId = employeeStep.getEmployeeId();
        // And the user clicks on the Save button
        employeeStep.clickSaveBtn();
        // Then the new employee should be added successfully
        employeeStep.verifyThatEmployeeIsAdded(employeeId, first + " " + middle);
        // And take a screenshot
        takeScreenshot();
    }
}
