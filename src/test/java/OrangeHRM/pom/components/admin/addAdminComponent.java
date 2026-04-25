package OrangeHRM.pom.components.admin;

import OrangeHRM.pom.pages.employeePage;
import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

public class addAdminComponent extends employeePage {
    public addAdminComponent(BasePage basePage) {
        super(basePage.page);
    }

    NamedLocator userRolesDropdown = NamedLocator.of(
            page.locator("//label[text()='User Role']/following::div[contains(@class, 'oxd-select-text-input')][1]"),
            "User Roles Dropdown");
    NamedLocator userStatusOption = NamedLocator.of(
            page.locator("//label[text()='Status']/following::div[contains(@class, 'oxd-select-text-input')][1]"),
            "User Status Option");
    NamedLocator employeeNameInput = NamedLocator.of(
            page.locator("//label[text()='Employee Name']/following::input[1]"), "Employee Name Input");
    NamedLocator userNameInput = NamedLocator.of(page.locator("//label[text()='Username']/following::input[1]"),
            "Username Input");
    NamedLocator passwordInput = NamedLocator.of(page.locator("//label[text()='Password']/following::input[1]"),
            "Password Input");
    NamedLocator confirmPasswordInput = NamedLocator
            .of(page.locator("//label[text()='Confirm Password']/following::input[1]"), "Confirm Password Input");

    NamedLocator saveButton = ElementUtils.elementBtnByText(page, "Save", "Save Button");
    
    public void AddAdmin(String role, String employeeName, String status, String username, String password) {
        fillValue(userRolesDropdown, role);
        fillValue(employeeNameInput, employeeName);
        fillValue(userStatusOption, status);
        fillValue(userNameInput, username);
        fillValue(passwordInput, password);
        fillValue(confirmPasswordInput, password);
        clickSaveButton();
    }

    public void clickSaveButton() {
        clickOnBtn(saveButton);
    }
}
