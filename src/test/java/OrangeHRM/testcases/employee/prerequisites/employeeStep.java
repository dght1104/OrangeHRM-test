package OrangeHRM.testcases.employee.prerequisites;

import OrangeHRM.pom.components.common.navbarComponent;
import OrangeHRM.pom.components.employee.addEmployeeComponent;
import OrangeHRM.pom.components.employee.listEmployeeComponent;
import OrangeHRM.pom.components.employee.navbarEmployeeComponent;
import OrangeHRM.pom.components.employee.searchEmployeeComponent;
import io.qameta.allure.Step;

import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.AssertUtils;

public class employeeStep {
    private navbarComponent navbarComponent;
    private addEmployeeComponent   addEmployeeComponent;
    private navbarEmployeeComponent navbarEmployeeComponent;
    private searchEmployeeComponent searchEmployeeComponent;
    private listEmployeeComponent listEmployeeComponent;

    public employeeStep(BasePage basePage) {
        navbarComponent = new navbarComponent(basePage);
        addEmployeeComponent = new addEmployeeComponent(basePage);
        navbarEmployeeComponent = new navbarEmployeeComponent(basePage);
        searchEmployeeComponent = new searchEmployeeComponent(basePage);
        listEmployeeComponent = new listEmployeeComponent(basePage);
    }

    @Step("Navigate to Employee page")
    public void navigateToEmployeePage() {
        navbarComponent.navigateToPIM();
    }

    @Step("Verify that the Employee page is displayed")
    public void verifyEmployeePage() {
        navbarComponent.verifyEmployeePage();
    }

    @Step("Navigate to Add Employee page")
    public void navigateToAddEmployeePage(){
        navbarEmployeeComponent.clickOnAddEmployeeBtn();
    }

    @Step("Add new employee with first name: {firstName}, middle name: {middleName} and last name: {lastName}") 
    public void addEmployee(String firstName, String middleName, String lastName) {
        addEmployeeComponent.addEmployee(firstName, lastName, middleName);
        addEmployeeComponent.getEmployeeId();
    }

    @Step("Click on the Save button")
    public void clickSaveBtn() {
        addEmployeeComponent.clickSaveBtn();
    }

    @Step("Get the employee id")
    public String getEmployeeId() {
        return addEmployeeComponent.getEmployeeId();
    }

    @Step("Get the first employee in the list")
    public String getTheFirstEmployeeInList(String employeeId) {
        return listEmployeeComponent.getTheFirstEmployeeInList(employeeId);
    }

    @Step("Verify that the employee is added successfully")
    public void verifyThatEmployeeIsAdded(String employeeId, String expectedString) {
        navbarEmployeeComponent.clickOnEmployeeListBtn();
        searchEmployeeComponent.searchEmployeeById(employeeId);
        searchEmployeeComponent.clickOnSearchBtn();
        String actualEmployeeName = listEmployeeComponent.getTheFirstEmployeeInList(employeeId);
        
        AssertUtils.assertEquals(actualEmployeeName, expectedString, "Verify that the employee is added successfully");
    }

    @Step("Click on the Delete button of the searched employee")
    public void deleteTheSearchedEmployee() {
        listEmployeeComponent.clickTheDeleteBtn();
        listEmployeeComponent.confirmDeleteAction();
    }

    @Step("Verify that the employee is deleted")
    public void verifyThatEmployeeIsDeleted(String employeeId) {
        navbarEmployeeComponent.clickOnEmployeeListBtn();
        searchEmployeeComponent.searchEmployeeById(employeeId);
        searchEmployeeComponent.clickOnSearchBtn();
        String recordCount = listEmployeeComponent.getRecordCount();
        AssertUtils.assertEquals("No Records Found", recordCount, "Verify that the employee is deleted");
    }
}