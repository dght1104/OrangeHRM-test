package OrangeHRM.testcases.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.login.prerequisites.loginStep;
import OrangeHRM.testcases.ui.prerequisites.uiStep;
import io.qameta.allure.Description;

public class verifyMenuItemTextIsCorrect extends BaseTestCase {

    private loginStep loginStep;
    private uiStep uiStep;

    @BeforeMethod
    public void setUp() {
        loginStep = new loginStep(basePage);
        uiStep = new uiStep(basePage);
    }

    List<String> expected = List.of(
            "Admin",
            "PIM",
            "Leave",
            "Time",
            "Recruitment",
            "My Info",
            "Performance",
            "Dashboard",
            "Directory",
            "Maintenance",
            "Claim",
            "Buzz");

    @Test
    @Description("")
    public void verifyMenuItemTextIsCorrect() {
        
        loginStep.loginToTheApplication("Admin", "admin123");

        List<String> actual = uiStep.getTheTitleOfTheMenuItem();

        uiStep.verifyMenuItemTextIsCorrect(actual,expected);
    }

}
