package OrangeHRM.testcases.admin.prerequisites;

import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.AssertUtils;

import OrangeHRM.pom.components.admin.addAdminComponent;
import OrangeHRM.pom.components.admin.listAdminComponent;
import OrangeHRM.pom.components.admin.navbarAdminComponent;
import OrangeHRM.pom.components.admin.searchAdminComponent;
import OrangeHRM.pom.components.common.navbarComponent;
import io.qameta.allure.Step;

public class adminStep {
    private navbarComponent navbarComponent;
    private navbarAdminComponent navbarAdminComponent;
    private addAdminComponent addAdminComponent;
    private searchAdminComponent searchAdminComponent;
    private listAdminComponent listAdminComponent;

    public adminStep(BasePage base) {
        navbarComponent = new navbarComponent(base);
        addAdminComponent = new addAdminComponent(base);
        navbarAdminComponent = new navbarAdminComponent(base);
        searchAdminComponent = new searchAdminComponent(base);
        listAdminComponent = new listAdminComponent(base);
    }

    @Step("Navigate To Admin Page")
    public void navigateToAdminPage() {
        navbarComponent.navigateToAdmin();
    }

    @Step("Click on Add Admin button")
    public void clickOnAddAdminButton() {
        navbarAdminComponent.clickOnAddAdminBtn();
    }

    @Step("Add Admin with the following details: {0}, {1}, {2}, {3}, {4}")
    public void addAdmin(String role, String employeeName, String status, String username, String password) {
        addAdminComponent.AddAdmin(role, employeeName, status, username, password);
    }

    @Step("Verify that the admin with username {0} is added successfully")
    public void verifyAdminAddedSuccessfully(String username) {
        navigateToAdminPage();
        searchAdminComponent.searchAdminByUsername(username);
        searchAdminComponent.clickOnSearchBtn();
        String actualUsername = listAdminComponent.getNameOfTheFirstAdminInList();
        AssertUtils.assertEquals(actualUsername, username, "The added admin should be displayed in the search results");
    }
}
