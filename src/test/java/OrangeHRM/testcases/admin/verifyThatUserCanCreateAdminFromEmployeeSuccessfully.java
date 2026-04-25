package OrangeHRM.testcases.admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.annotations.TestCaseId;

import com.OrangeHRM.utils.IdGenerator;

import OrangeHRM.testcases.admin.prerequisites.adminStep;
import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.employee.prerequisites.employeeStep;
import OrangeHRM.testcases.login.prerequisites.loginStep;

public class verifyThatUserCanCreateAdminFromEmployeeSuccessfully extends BaseTestCase {

    private adminStep adminStep;
    private loginStep loginStep;
    private employeeStep employeeStep;

    @BeforeMethod
    public void setUp() {
        adminStep = new adminStep(basePage);
        loginStep = new loginStep(basePage);
        employeeStep = new employeeStep(basePage);
    }

    String firstname = "Hattori";
    String lastname = "Heiji";
    String middlename = "Kansai";
    String name = firstname + " " + middlename;
    String empID = IdGenerator.generateEmployeeId();
    String username = firstname.trim().toLowerCase()
            + "."
            + lastname.trim().toLowerCase() + IdGenerator.generateRandomString();

    @Test(description = "Verify that user can create admin from employee successfully")
    @TestCaseId("4.1")
    public void verifyThatUserCanCreateAdminFromEmployeeSuccessfully() {
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
        // And the user navigates to the Admin page
        adminStep.navigateToAdminPage();
        // Click on the Add Admin button
        adminStep.clickOnAddAdminButton();
        // Add a new admin with the following details: role, employee name, status,
        // username, password, and confirm password
        adminStep.addAdmin("ESS", firstname, "Enabled", username, "Password123!");
        // Then the new admin should be added successfully
        adminStep.verifyAdminAddedSuccessfully(username);
        // And take a screenshot
        takeScreenshot();
    }

}
