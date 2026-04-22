package OrangeHRM.pom.components;

import com.OrangeHRM.managers.BasePage;

import OrangeHRM.pom.pages.homePage;

public class IndexComponent extends homePage{

    public IndexComponent(BasePage basePage) {
        super(basePage.page);
    }

    public void navigateToIndex() {
        navigateToUrl("https://opensource-demo.orangehrmlive.com");
    }
}
