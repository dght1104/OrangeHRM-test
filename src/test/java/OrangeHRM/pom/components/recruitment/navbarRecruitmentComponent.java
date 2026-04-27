package OrangeHRM.pom.components.recruitment;

import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;
import OrangeHRM.pom.pages.recruitmentPage;
import io.qameta.allure.internal.shadowed.jackson.databind.util.Named;

public class navbarRecruitmentComponent extends recruitmentPage {
    public navbarRecruitmentComponent(BasePage basePage) {
        super(basePage.page);}

    NamedLocator CandidatesBtn = ElementUtils.elementByTextAndTag(page, "a", "Candidates","Candidates Button");
    NamedLocator VacanciesBtn = ElementUtils.elementByTextAndTag(page, "a", "Vacancies","Vacancies Button");
    NamedLocator AddnewBtn = ElementUtils.elementBtnByText(page, "Add", "Add Button");
    public void clickCandidatesBtn() {
        clickOnBtn(CandidatesBtn);
    }
    public void clickVacanciesBtn() {
        clickOnBtn(VacanciesBtn);
    }

}
