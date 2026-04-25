package OrangeHRM.testcases.employee;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.employee.prerequisites.employeeStep;
import OrangeHRM.testcases.login.prerequisites.loginStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.annotations.TestCaseId;

public class verifyThatUserCanDeleteEmployee extends BaseTestCase {
    private employeeStep employeeStep;
    private loginStep loginStep;

    @BeforeMethod
    public void init() {
        employeeStep = new employeeStep(basePage);
        loginStep = new loginStep(basePage);
    }

    //===== data  =====
    String firstname = "Gorden";
    String lastname = "JARELfs";
    String middlename = "Billies";
    String name = firstname + " " + middlename;
    
    @Test(description = "Verify that user can delete employee")
    @TestCaseId("3.1")
    public void verifyThatUserCanDeleteEmployee() {
       // When the user logs in to the application
        loginStep.loginToTheApplication("Admin", "admin123");
        // And the user navigates to the Employee page
        employeeStep.navigateToEmployeePage();
        // And the user clicks on the Add Employee button
        employeeStep.navigateToAddEmployeePage();
        // And the user fills in the employee details
        employeeStep.addEmployee(firstname, middlename, lastname);
        // And gets the employee id
        String employeeId = employeeStep.getEmployeeId();
        // And the user clicks on the Save button
        employeeStep.clickSaveBtn();
        // Then the new employee should be added successfully
        employeeStep.verifyThatEmployeeIsAdded(employeeId, name);
        // And take a screenshot
        takeScreenshot();
        // When the user clicks on the Delete button
        employeeStep.deleteTheSearchedEmployee();
        // Then verify the employee should be deleted successfully
        employeeStep.verifyThatEmployeeIsDeleted(employeeId);
        // And take a screenshot
        takeScreenshot();
    }
}
