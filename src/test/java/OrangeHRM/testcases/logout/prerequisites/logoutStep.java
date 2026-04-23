package OrangeHRM.testcases.logout.prerequisites;

import com.OrangeHRM.managers.BasePage;

import OrangeHRM.pom.components.common.navbarComponent;
import io.qameta.allure.Step;

public class logoutStep {
    private navbarComponent navbarcComponent;

    public logoutStep(BasePage basePage) {
        this.navbarcComponent = new navbarComponent(basePage);
    }

    @Step("Click The User Profile Icon")
    public void clickUserProfileIcon() {
        navbarcComponent.clickUserMenu();
    }

    @Step("Click The Logout Button")
    public void clickLogoutButton() {
        navbarcComponent.clickLogoutButton();
    }
}
