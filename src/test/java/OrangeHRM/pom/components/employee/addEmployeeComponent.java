package OrangeHRM.pom.components.employee;

import OrangeHRM.pom.pages.employeePage;
import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

public class addEmployeeComponent extends employeePage {
    public  addEmployeeComponent(BasePage basePage) {
        super(basePage.page);
    }

    NamedLocator employeeFirstNameInput= NamedLocator.of(page.locator("//div[contains(@class,'--name-grouped-field')]//input[@placeholder='First Name']") ,"First Name Input");
    NamedLocator employeeLastNameInput= NamedLocator.of(page.locator("//div[contains(@class,'--name-grouped-field')]//input[@placeholder='Last Name']") ,"Last Name Input");
    NamedLocator employeeMiddleInput= NamedLocator.of(page.locator("//div[contains(@class,'--name-grouped-field')]//input[@placeholder='Middle Name']") ,"Middle Name Input");
    NamedLocator employeeIdInput= NamedLocator.of(page.locator("//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input") ,"Employee Id Input");
    NamedLocator saveBtn= ElementUtils.elementBtnByText(page,"Save", "Save Button");
   
    public void addEmployee(String firstName, String lastName, String middleName, String ID) {
        setText(employeeFirstNameInput, firstName);
        setText(employeeLastNameInput, lastName);
        setText(employeeMiddleInput, middleName);
        setText(employeeIdInput, ID);
    }

    public void clickSaveBtn() {
        clickOnBtn(saveBtn);
    }

    public String getEmployeeId() {
        return getValue(employeeIdInput);
    }
}
