package OrangeHRM.pom.components;

import com.OrangeHRM.constants.AppConfig;
import com.OrangeHRM.managers.BasePage;

import OrangeHRM.pom.pages.homePage;

public class IndexComponent extends homePage{

    public IndexComponent(BasePage basePage) {
        super(basePage.page);
    }

    public void navigateToLoginPage() {
        navigateToUrl(AppConfig.BASEURL);
    }
}
