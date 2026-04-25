package OrangeHRM.testcases.employee;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.employee.prerequisites.employeeStep;
import OrangeHRM.testcases.login.prerequisites.loginStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.annotations.TestCaseId;
import com.OrangeHRM.utils.IdGenerator;

public class verifyThatUserCanAddNewEmployee extends BaseTestCase {
    private employeeStep employeeStep;
    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        employeeStep = new employeeStep(basePage);
        loginStep = new loginStep(basePage);
    }

    // ===== data =====
    String firstname = "John";
    String lastname = "Doe";
    String middlename = "Ramsay";
    String name = firstname + " " + middlename;
String empID = IdGenerator.generateEmployeeId();
    @Test(description = "Verify that user can add new employee")
    @TestCaseId("3.1.1")
    public void verifyThatUserCanAddNewEmployee() {
        // When the user logs in to the application
        loginStep.loginToTheApplication("Admin", "admin123");
        // And the user navigates to the Employee page
        employeeStep.navigateToEmployeePage();
        // And the user clicks on the Add Employee button
        employeeStep.navigateToAddEmployeePage();
        // And the user fills in the employee details
        employeeStep.addEmployee(firstname, middlename, lastname, empID);
        // And the user clicks on the Save button
        employeeStep.clickSaveBtn();
        // Then the new employee should be added successfully
        employeeStep.verifyThatEmployeeIsAdded(empID, name);
        // And take a screenshot
        takeScreenshot();
    }
}
