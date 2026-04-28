package OrangeHRM.pom.components.recruitment;

import OrangeHRM.pom.pages.adminPage;
import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

public class addVacanciesComponent extends adminPage {
        public addVacanciesComponent(BasePage basePage) {
                super(basePage.page);
        }

        NamedLocator VacancyInput = NamedLocator.of(page
                        .locator("//label[text()='Vacancy Name']/following::input[1]"),
                        "Vacancy Input");
        NamedLocator JobTitleInput = NamedLocator.of(
                        page.locator("//label[contains(text(),'Job Title')]/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]"),
                        "Job Title Input");
        NamedLocator DescriptionInput = NamedLocator.of(page
                        .locator("//label[contains(text(),'Description')]/ancestor::div[contains(@class,'oxd-input-group')]//textarea"),
                        "Description");
        NamedLocator HiringManagerInput = NamedLocator.of(page
                        .locator("//label[contains(text(),'Hiring Manager')]/ancestor::div[contains(@class,'oxd-input-group')]//input"),
                        "Hiring Manager");
        NamedLocator NumberOfPositionsInput = NamedLocator.of(page
                        .locator("//label[contains(text(),'Number of Positions')]/ancestor::div[contains(@class,'oxd-input-group')]//input"),
                        "Number of Positions");
        NamedLocator SaveButton = ElementUtils.elementBtnByText(page, "Save", "Save Button");

        public void addVacancies(String vacancyName, String jobTitle, String description, String hiringManager, String numberOfPositions) {
                fillValue(VacancyInput,vacancyName);
                fillValue(JobTitleInput, jobTitle);
                fillValue(DescriptionInput, description);
                fillValue(HiringManagerInput, hiringManager);
                fillValue(NumberOfPositionsInput, numberOfPositions);
        }
        public void clickSaveButton() {
                clickOnBtn(SaveButton);
        }
}
