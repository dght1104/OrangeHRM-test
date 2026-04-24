package OrangeHRM.pom.components.employee;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

import OrangeHRM.pom.pages.employeePage;
import io.qameta.allure.internal.shadowed.jackson.databind.util.Named;

public class navbarEmployeeComponent extends employeePage {
    public navbarEmployeeComponent(BasePage basePage) {
        super(basePage.page);}

    NamedLocator addEmployeeBtn = ElementUtils.elementByTextAndTag(page, "a", "Add Employee","Add Employee Button");
    NamedLocator employeeListBtn = ElementUtils.elementByTextAndTag(page, "a", "Employee List","Employee List Button");
    
    public void clickOnAddEmployeeBtn() {
        clickOnBtn(addEmployeeBtn);
    }
    public void clickOnEmployeeListBtn() {
        clickOnBtn(employeeListBtn);
    }
}
