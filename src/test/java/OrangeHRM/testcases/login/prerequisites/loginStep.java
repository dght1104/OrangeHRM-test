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

    @Step("Enter Username and Password")
    public void enterUsernameAndPassword(String username, String password) {
        indexComponent.enterUsername(username);
        indexComponent.enterPassword(password);
    }

    public void clickLoginButton() {
        indexComponent.clickLoginButton();
    }

    public void verifyUserIsLoggedIn() {
        indexComponent.verifyUserIsLoggedIn();
    }

    public void verifyUserIsNotLoggedIn() {
       indexComponent.verifyUserIsNotLoggedIn();
    }
}
