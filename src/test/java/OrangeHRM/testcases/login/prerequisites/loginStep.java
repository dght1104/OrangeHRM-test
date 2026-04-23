package OrangeHRM.testcases.login.prerequisites;

import com.OrangeHRM.managers.BasePage;

import OrangeHRM.pom.components.IndexComponent;
import io.qameta.allure.Step;

public class loginStep {
    private IndexComponent indexComponent;

    public loginStep(BasePage basePage) {
        indexComponent = new IndexComponent(basePage);
    }
    
    @Step("Navigate to Login Page")
    public void navigateToLoginPage() {
        indexComponent.navigateToLoginPage();
    }
}
