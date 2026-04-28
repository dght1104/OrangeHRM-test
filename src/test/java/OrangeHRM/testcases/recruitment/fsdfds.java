package OrangeHRM.testcases.recruitment;

import OrangeHRM.testcases.base.BaseTestCase;
import OrangeHRM.testcases.login.prerequisites.loginStep;
import OrangeHRM.testcases.recruitment.prerequisites.recruitmentStep;
import org.testng.annotations.BeforeMethod;

public class fsdfds extends BaseTestCase {
    private loginStep loginStep;
    private recruitmentStep recruitmentStep;

    @BeforeMethod
    public void setUp()
    {
        loginStep = new loginStep(basePage);
        recruitmentStep = new recruitmentStep(basePage);
    }

    public void dfsdfsdfsdfadfadsfd(){
        loginStep.loginToTheApplication("Admin", "admin123");

        recruitmentStep.navigateToTheRecruitmentPage();

        recruitmentStep.navigateToTheAddCandidatesPage();

        recruitmentStep.AddCandidate("df","fasdf","dfasd","sfsd");

        recruitmentStep.clickOnSaveButton();
    }

    public void verifyThatUserCanCreateAdminFromEmployeeSuccessfully() {
        loginStep.loginToTheApplication("Admin", "admin123");

        recruitmentStep.navigateToTheAddVacanciesPage();

        recruitmentStep.addVacancy("df","fasdf","dfasd","Jane Smith Doe","asdfsdf");

        recruitmentStep.clickOnSaveButton();


    }
}
