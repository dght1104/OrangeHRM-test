package OrangeHRM.pom.components.common;

import java.util.jar.Attributes.Name;

import javax.swing.text.html.parser.Element;

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
    
    public void clickUserMenu() {
        clickOnBtn(UserMenu);
    }

    public void clickLogoutButton() {
        clickOnBtn(LogoutBtn);
    }
    
}
