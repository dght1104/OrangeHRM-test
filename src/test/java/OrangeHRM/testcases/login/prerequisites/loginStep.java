package OrangeHRM.testcases.login.prerequisites;

import com.OrangeHRM.managers.BasePage;

import OrangeHRM.pom.components.index.IndexComponent;
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

    @Step("Click on Login Button")
    public void clickLoginButton() {
        indexComponent.clickLoginButton();
    }

    @Step("Verify User is Logged In")
    public void verifyUserIsLoggedIn() {
        indexComponent.verifyUserIsLoggedIn();
    }

    @Step("Verify User is Not Logged In")
    public void verifyUserIsNotLoggedIn() {
       indexComponent.verifyUserIsNotLoggedIn();
    }

    @Step("Login To The Application")
    public void loginToTheApplication(String username, String password) {
        navigateToLoginPage();
        enterUsernameAndPassword(username, password);
        clickLoginButton();
    }

    public void verifyThatLoginPageIsDisplayed() {
        indexComponent.verifyThatLoginPageIsDisplayed();
    }
}
