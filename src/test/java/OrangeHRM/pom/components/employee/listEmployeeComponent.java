package OrangeHRM.pom.components.employee;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

import OrangeHRM.pom.pages.employeePage;
public class listEmployeeComponent extends employeePage {
    public listEmployeeComponent(BasePage basePage) {
        super(basePage.page);
    }
    
    public String getTheFirstEmployeeInList(String employeeId) {
        NamedLocator employeeInList = ElementUtils.elementByClassTagAndIndex(page, "div", "oxd-table-cell oxd-padding-cell", 3, "First employee in the list");
        return getTextContent(employeeInList);
    }
}