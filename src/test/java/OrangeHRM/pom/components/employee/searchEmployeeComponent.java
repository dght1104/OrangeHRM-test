package OrangeHRM.pom.components.employee;

import OrangeHRM.pom.pages.employeePage;
import io.qameta.allure.internal.shadowed.jackson.databind.util.Named;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

public class searchEmployeeComponent extends employeePage {
    public searchEmployeeComponent(BasePage basePage){
        super(basePage.page);
    }
    NamedLocator employeeIdInput= NamedLocator.of(page.locator("//div[contains(@class,'oxd-input-group')][.//label[normalize-space()='Employee Id']]//input "), "Employee Id Input");
    NamedLocator searchBtn= ElementUtils.elementBtnByText(page,"Search", "Search Button");
    
    public void searchEmployeeById(String employeeId) {
        setText(employeeIdInput, employeeId);
    }

    public void clickOnSearchBtn() {
        clickOnBtn(searchBtn);
    }

    



}
