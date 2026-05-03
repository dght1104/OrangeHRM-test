package OrangeHRM.testcases.ui.prerequisites;

import java.util.ArrayList;
import java.util.List;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.AssertUtils;
import com.OrangeHRM.utils.ElementUtils;

import io.qameta.allure.Step;

public class uiStep {
    private  BasePage basePage;
    public uiStep(BasePage basePage){
        this.basePage = basePage;
    }

    @Step("Get The Title Of The Menu Item")
    public List<String> getTheTitleOfTheMenuItem(){

        List<String> titles = new ArrayList<>();

        for(int i = 1; i<=12 ; i++){
            NamedLocator titleName = ElementUtils.elementByClassTagAndIndex(basePage.getPage(), "li", "oxd-main-menu-item-wrapper", i, "Titel");

            String title = titleName.get().innerText();
            System.out.println(title);
            titles.add(title);
        }
        return titles;
    }


    @Step("Verify That The Menu Item Is Displayed Correctly")
    public void verifyMenuItemTextIsCorrect(List<String> name, List<String>title){
        for(int i = 0; i< name.size();i++){
            AssertUtils.assertEquals(name.get(i), title.get(i), "That The Menu Item Is Displayed Correctly");
        }
    }

}
