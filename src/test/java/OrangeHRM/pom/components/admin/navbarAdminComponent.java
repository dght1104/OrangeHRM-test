package OrangeHRM.pom.components.admin;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;
import OrangeHRM.pom.pages.employeePage;

public class navbarAdminComponent extends employeePage {
    public navbarAdminComponent(BasePage basePage) {
        super(basePage.page);}

    NamedLocator addAdminBtn = ElementUtils.elementBtnByText(page, "Add", "Add Admin Button");
    NamedLocator employeeListBtn = ElementUtils.elementByTextAndTag(page, "a", "Employee List","Employee List Button");
    
    public void clickOnAddAdminBtn() {
        clickOnBtn(addAdminBtn);
    }
    public void clickOnEmployeeListBtn() {
        clickOnBtn(employeeListBtn);
    }
}
