package OrangeHRM.testcases.test.prequesuite;

import com.OrangeHRM.managers.BasePage;

import OrangeHRM.pom.components.IndexComponent;

public class loginStep {
    private IndexComponent indexComponent;

    public loginStep(BasePage basePage) {
        indexComponent = new IndexComponent(basePage);
    }
    
    public void login() {
        indexComponent.navigateToIndex();
    }
}
