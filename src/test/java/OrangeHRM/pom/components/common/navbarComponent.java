package OrangeHRM.pom.components.common;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;
import OrangeHRM.pom.pages.homePage;

public class navbarComponent extends homePage {
    public navbarComponent(BasePage basePage) {
        super(basePage.page );
    }

    NamedLocator UserMenu = ElementUtils.elementByClass(page, "oxd-userdropdown-tab", "User Menu");
    NamedLocator LogoutBtn = ElementUtils.elementByText(page, "Logout", "Logout Button");
    NamedLocator PIMBtn = ElementUtils.elementByClassAndTextAndTag(page,"span","oxd-text oxd-text--span oxd-main-menu-item--name","PIM","PIM btn");
    
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
    
}
