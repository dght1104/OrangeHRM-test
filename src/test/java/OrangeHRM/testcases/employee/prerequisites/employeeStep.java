package OrangeHRM.testcases.employee.prerequisites;

import OrangeHRM.pom.components.common.navbarComponent;
import OrangeHRM.pom.pages.employeePage;
import com.OrangeHRM.managers.BasePage;

public class employeeStep {
    private navbarComponent navbarComponent;

    public employeeStep(BasePage basePage) {
        navbarComponent = new navbarComponent(basePage);
    }

    public void navigateToEmployeePage() {
        navbarComponent.navigateToPIM();
    }

    public void verifyEmployeePage() {
        navbarComponent.verifyEmployeePage();
    }

    public void navigateToAddEmployeePage(){

    }

}