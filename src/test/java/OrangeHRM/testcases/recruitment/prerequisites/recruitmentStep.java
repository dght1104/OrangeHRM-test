package OrangeHRM.testcases.recruitment.prerequisites;

import OrangeHRM.pom.components.common.navbarComponent;
import OrangeHRM.pom.components.recruitment.addCandidatesComponent;
import OrangeHRM.pom.components.recruitment.addVacanciesComponent;
import OrangeHRM.pom.components.recruitment.navbarRecruitmentComponent;
import com.OrangeHRM.managers.BasePage;

public class recruitmentStep {
    private  BasePage basePage;
    private addVacanciesComponent addVacanciesComponent;
    private addCandidatesComponent addCandidateComponent;
    private navbarComponent navbarComponent;
    private navbarRecruitmentComponent navbarRecruitmentComponent;

    public recruitmentStep(BasePage basePage) {
        this.basePage = basePage;
        addVacanciesComponent = new addVacanciesComponent(basePage);
        addCandidateComponent = new addCandidatesComponent(basePage);
        navbarComponent = new navbarComponent(basePage);
        navbarRecruitmentComponent = new navbarRecruitmentComponent(basePage);
    }
    public void navigateToTheRecruitmentPage() {
        navbarComponent.navigateToRecruitment();
    }

    public void navigateToTheAddVacanciesPage() {
        navbarRecruitmentComponent.clickVacanciesBtn();
    }

    public void navigateToTheAddCandidatesPage() {
        navbarRecruitmentComponent.clickCandidatesBtn();
    }

    public void addVacancy(String vacancyName, String jobTitle, String description, String hiringManager, String numberOfPositions) {
        addVacanciesComponent.addVacancies(vacancyName, jobTitle, description, hiringManager, numberOfPositions);
    }

    public void AddCandidate(String firstName, String lastName, String middleName, String vacancy) {
        addCandidateComponent.AddCandidate(firstName, lastName, middleName, vacancy);
    }

    public void clickOnSaveButton() {
        String text = basePage.getPage().locator("//h6[contains(@class,'orangehrm-main-title')]").textContent();
        if(text.equals("Add Candidate")){
            addCandidateComponent.clickSaveButton();
        }
        else {
            addVacanciesComponent.clickSaveButton();
        }
    }

    public void verifyThatVacancyIsAdded(){

    }
}
