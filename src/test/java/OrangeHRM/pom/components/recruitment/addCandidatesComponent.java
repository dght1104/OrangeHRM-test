package OrangeHRM.pom.components.recruitment;

import OrangeHRM.pom.pages.adminPage;
import com.OrangeHRM.dto.NamedLocator;
import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.utils.ElementUtils;

public class addCandidatesComponent extends adminPage {
        public addCandidatesComponent(BasePage basePage) {
                super(basePage.page);
        }

        NamedLocator CandidateFirstNameInput = NamedLocator.of(page
                        .locator("//div[contains(@class,'--name-grouped-field')]//input[@placeholder='First Name']"),
                        "First Name Input");
        NamedLocator CandidateLastNameInput = NamedLocator.of(
                        page.locator("//div[contains(@class,'--name-grouped-field')]//input[@placeholder='Last Name']"),
                        "Last Name Input");
        NamedLocator CandidateMiddleInput = NamedLocator.of(page
                        .locator("//div[contains(@class,'--name-grouped-field')]//input[@placeholder='Middle Name']"),
                        "Middle Name Input");
        NamedLocator CandidateEmailInput = NamedLocator.of(page
                        .locator("//label[text()='Email']/ancestor::div[contains(@class,'oxd-input-group')]//input"),
                        "Email Input");
        NamedLocator CandidateContactInput = NamedLocator.of(page
                        .locator("//label[text()='Contact Number']/ancestor::div[contains(@class,'oxd-input')]//input"),
                        "Contact Number Input");
        NamedLocator CandidateVancancyDropdown = NamedLocator.of(page
                        .locator("//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text-input')]"),
                        "Vacancy Dropdown");
        NamedLocator SaveButton = ElementUtils.elementBtnByText(page, "Save", "Save Button");

        public void AddCandidate(String firstName, String lastName, String middleName, String vacancy) {
                fillValue(CandidateFirstNameInput, firstName);
                fillValue(CandidateLastNameInput, lastName);
                fillValue(CandidateMiddleInput, middleName);
                String phone = "09" + (int) (Math.random() * 1_000_000_00);
                fillValue(CandidateContactInput, phone);
                fillValue(CandidateVancancyDropdown, vacancy);
                String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "_"
                                + (int) (Math.random() * 1_000) + "@example.com";
                fillValue(CandidateEmailInput, email);
        }

        public void clickSaveButton() {
                clickOnBtn(SaveButton);
        }
}
