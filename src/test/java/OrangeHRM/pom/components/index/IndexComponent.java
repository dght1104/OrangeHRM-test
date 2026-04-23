package OrangeHRM.pom.components.index;

import com.OrangeHRM.constants.AppConfig;
import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.AssertUtils;
import com.OrangeHRM.utils.ElementUtils;
import OrangeHRM.pom.pages.homePage;
import io.qameta.allure.internal.shadowed.jackson.databind.util.Named;

public class IndexComponent extends homePage{

    public IndexComponent(BasePage basePage) {
        super(basePage.page);
    }

    NamedLocator userNameFill = ElementUtils.inputFieldByName(page, "Username", "Username Field");
    NamedLocator passwordFill = ElementUtils.inputFieldByName(page, "Password", "Password Field");
    NamedLocator loginBtn = ElementUtils.elementBtnByText(page, "Login", "Login Button");
    NamedLocator loginHeader = ElementUtils.elementByClass(page, "oxd-text oxd-text--h5 orangehrm-login-title", "Login Header");

    public void navigateToLoginPage() {
        navigateToUrl(AppConfig.BASEURL);
    }

    public void enterUsername(String username) {
        setText(userNameFill, username);
    }

    public void enterPassword(String password) {
        setText(passwordFill, password);
    }

    public void clickLoginButton() {
        clickOnBtn(loginBtn);
    }

    public void verifyUserIsLoggedIn() {
    //    page.waitForURL("**/dashboard/index");

        waitForURL("**/dashboard/index");
        AssertUtils.verifyTrue(
            page.url().contains("/dashboard/index"),
            "User is not logged in successfully."
        );
    }

    public void verifyUserIsNotLoggedIn() {
        AssertUtils.verifyFalse(
            page.url().contains("/dashboard/index"),
            "User is logged in successfully."
        );
    }

    public void verifyThatLoginPageIsDisplayed() {
        AssertUtils.verifyTrue(
            verifyElementVisible(loginHeader),
            "Login page is not displayed."
        );
    }
}
