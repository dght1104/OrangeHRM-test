package OrangeHRM.pom.components.admin;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

import OrangeHRM.pom.pages.employeePage;
import io.qameta.allure.internal.shadowed.jackson.databind.util.Named;
public class listAdminComponent extends employeePage {
    public listAdminComponent(BasePage basePage) {
        super(basePage.page);
    }
    
    NamedLocator deleteBtn = ElementUtils.elementByClassAndTag(page, "i", "oxd-icon bi-trash", "Delete button");
    NamedLocator confirmDeleteBtn = ElementUtils.elementBtnByText(page, "Yes, Delete", "Confirm delete button");
    NamedLocator recordCountLabel = ElementUtils.elementByClassAndText(page, "span", "Record", "Record label");
    
    public String getNameOfTheFirstAdminInList() {
        waitForTimeout(2);
        NamedLocator adminNameInList = ElementUtils.elementByClassTagAndIndex(page, "div", "oxd-table-cell oxd-padding-cell", 2, "First Admin in the list");
        return getTextContent(adminNameInList);
    }

    public void clickTheDeleteBtn() {
        clickOnBtn(deleteBtn);
    }

    public void confirmDeleteAction() {
        clickOnBtn(confirmDeleteBtn);
    }

    public String getRecordCount() {
        waitForTimeout(2);
        return getTextContent(recordCountLabel);
    }
}