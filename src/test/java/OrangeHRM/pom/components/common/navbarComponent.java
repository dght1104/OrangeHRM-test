package OrangeHRM.pom.components.common;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;
import OrangeHRM.pom.pages.homePage;
import io.qameta.allure.internal.shadowed.jackson.databind.util.Named;

public class navbarComponent extends homePage {
    public navbarComponent(BasePage basePage) {
        super(basePage.page );
    }

    NamedLocator UserMenu = ElementUtils.elementByClass(page, "oxd-userdropdown-tab", "User Menu");
    NamedLocator LogoutBtn = ElementUtils.elementByText(page, "Logout", "Logout Button");
    NamedLocator PIMBtn = ElementUtils.elementByClassAndTextAndTag(page,"span","oxd-text oxd-text--span oxd-main-menu-item--name","PIM","PIM btn");
    NamedLocator AdminBtn = ElementUtils.elementByClassAndTextAndTag(page,"span","oxd-text oxd-text--span oxd-main-menu-item--name","Admin","Admin btn");
    NamedLocator RecruitmentBtn = ElementUtils.elementByClassAndTextAndTag(page,"span","oxd-text oxd-text--span oxd-main-menu-item--name","Recruitment","Recruitment btn");
    public void clickUserMenu() {
        clickOnBtn(UserMenu);
    }

    public void clickLogoutButton() {
        clickOnBtn(LogoutBtn);
    }

    public void navigateToPIM() {
        clickOnBtn(PIMBtn);
    }

    public void verifyEmployeePage() {
        isOnPage("pim/viewEmployeeList");
    }

    public void navigateToAdmin() {
        clickOnBtn(AdminBtn);
    }

    public void verifyAdminPage() {
        isOnPage("admin/viewSystemUsers");
    }

    public void navigateToRecruitment() {
        clickOnBtn(RecruitmentBtn);
    }
    
}
