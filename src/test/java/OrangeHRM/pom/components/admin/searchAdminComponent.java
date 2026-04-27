package OrangeHRM.pom.components.admin;

import OrangeHRM.pom.pages.adminPage;
import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

public class searchAdminComponent extends adminPage {
    public searchAdminComponent(BasePage basePage){
        super(basePage.page);
    }
    NamedLocator usernameInput = NamedLocator.of(page.locator("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input"), "Username Input");
    NamedLocator searchBtn= ElementUtils.elementBtnByText(page,"Search", "Search Button");
    
    public void searchAdminByUsername(String username) {
        waitForTimeout(2);
        setText(usernameInput, username);
    }

    public void clickOnSearchBtn() {
        clickOnBtn(searchBtn);
    }
}
