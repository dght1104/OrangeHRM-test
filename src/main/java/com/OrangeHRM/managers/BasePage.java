package com.OrangeHRM.managers;

import com.OrangeHRM.dto.NamedLocator;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;

public class BasePage {

    public Page page;
    public BrowserContext browserContext;

    public BasePage(Page page1) {
        this.page = page1;
    }

    public BasePage(Page page, BrowserContext browser) {
        this.page = page;
        this.browserContext = browser;
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public BrowserContext getContext() {
        return browserContext;
    }

     public void switchTo(Page newPage) {
        this.page = newPage;
    }

    // Actions
    @Step("Navigate to url")
    public void navigateToUrl(String url) {
        this.page.navigate(url);
    }

    @Step("Input {value} in {namedLocator.name}")
    public void setText(NamedLocator namedLocator, String value) {
        namedLocator.locator().fill(value);
    }

    @Step("Check {namedLocator.name} is clickable")
    public boolean isClickable(NamedLocator namedLocator) {
        return namedLocator.locator().isVisible() && namedLocator.locator().isEnabled();
    }

    @Step("Check if {namedLocator.name} is checked")
    public boolean verifyElementChecked(NamedLocator namedLocator) {
        return namedLocator.locator().isChecked();
    }

    @Step("Click on {namedLocator.name}")
    public void clickOnBtn(NamedLocator namedLocator) {
        namedLocator.locator().click();
    }

    @Step("Check if {namedLocator.name} is visible")
    public boolean verifyElementVisible(NamedLocator namedLocator) {
        return namedLocator.locator().isVisible();
    }

    @Step("Press The {key} Key")
    public void pressKey(String key) {
        page.keyboard().press(key);
    }

    @Step("Check if {namedLocator.name} is editable")
    public boolean verifyElementEditable(NamedLocator namedLocator) {
        return namedLocator.locator().isEditable();
    }

    @Step("Fill with {value})")
    public void fillWithValue(String value) {
        page.keyboard().type(value);
    }

    @Step("Get text content from {namedLocator.name}")
    public String getTextContent(NamedLocator namedLocator) {
        return namedLocator.locator().textContent();
    }

    public boolean isOnPage(String expectedUrl) {
        try {
            page.waitForURL("**" + expectedUrl + "**");
            String currentUrl = page.url();
            return currentUrl.contains(expectedUrl);
        } catch (Exception e) {
            return false;
        }
    }

    protected NamedLocator getIconInRowByText(String rowText, String iconText) {
        return NamedLocator.of(
                page.locator("tr:has(td:has-text('" + rowText + "'))")
                        .locator("mat-icon:has-text('" + iconText + "')"),
                iconText + " icon of " + rowText);
    }

    @Step("Wait for {namedLocator.name} appear")
    public void waitForPageReady(NamedLocator namedLocator) {
        namedLocator.locator().waitFor();
    }

    @Step("When: User Click On Check Box")
    public void clickOnCheckBox(NamedLocator namedLocator) {
        try {
            namedLocator.locator().check();
        } catch (Exception e) {
            namedLocator.locator().click();
        }
    }

    @Step("Set {namedLocator.name} checkbox to {shouldCheck}")
    public void setCheckbox(NamedLocator namedLocator, boolean shouldCheck) {

        Locator checkbox = namedLocator.locator();
        checkbox.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        Locator input = checkbox.locator("input[type='checkbox']");
        Locator target = input.count() > 0 ? input : checkbox;

        boolean isChecked = target.isChecked();

        if (shouldCheck && !isChecked) {
            target.check();
        } else if (!shouldCheck && isChecked) {
            target.uncheck();
        }
    }

    @Step("Set {namedLocator.name} toggle to {shouldEnable}")
    public void setToggle(NamedLocator namedLocator, boolean shouldEnable) {

        Locator toggle = namedLocator.locator();

        toggle.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        // Lấy button role switch bên trong
        Locator button = toggle.locator("button[role='switch']");

        String ariaChecked = button.getAttribute("aria-checked");
        boolean isChecked = Boolean.parseBoolean(ariaChecked);

        if (shouldEnable != isChecked) {
            button.click();
        }
    }

    public void selectValueOfDropdown(NamedLocator namedLocator, String value) {

        Locator trigger = namedLocator.locator().locator(".mat-mdc-select-trigger");

        trigger.click();

        page.mouse().click(10, 10);

        Locator options = page.locator("mat-option");

        options.first().waitFor();

        Locator opt = options
                .filter(new Locator.FilterOptions().setHasText(value.trim()))
                .first();

        opt.click();

        page.waitForFunction("() => !document.querySelector('mat-option')");
    }

    @Step("Filling {namedLocator.name} with {value}")
    public void fillValue(NamedLocator namedLocator, String value) {

        Locator locator = namedLocator.locator();
        // Take element
        String tag = locator.evaluate("el => el.tagName.toLowerCase()").toString();

        switch (tag) {

            case "input":
            case "textarea":
                setText(namedLocator, value);
                break;

            case "mat-checkbox":
                setCheckbox(namedLocator, Boolean.parseBoolean(value));
                break;

            case "mat-slide-toggle":
                setToggle(namedLocator, Boolean.parseBoolean(value));
                break;

            case "mat-select":
                namedLocator.locator()
                        .locator(".mat-mdc-select-trigger")
                        .click();
                selectValueOfDropdown(namedLocator, value);
                break;

            case "button":
                clickOnBtn(namedLocator);
                break;

            default:
                // log.warn("Unsupported element: {}", tag);
        }
    }

    @Step("Fill a form")
    public void fillForm(NamedLocator[] namedLocators, String[] value) {
        for (int i = 0; i < namedLocators.length; i++) {
            fillValue(namedLocators[i], value[i]);
        }
    }

    // ================================= Wait For Element
    // ===============================
    @Step("Wait for {namedLocator.name} appear")
    public void waitForElement(NamedLocator namedLocator) {
        namedLocator.locator().waitFor();
    }

    @Step("Wait for {namedLocator.name} disappear")
    public void waitForElementDisappear(NamedLocator namedLocator) {
        namedLocator.locator().waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.HIDDEN));
    }

    @Step("Wait for {namedLocator.name} to be visible")
    public void waitForElementVisible(NamedLocator namedLocator) {
        namedLocator.locator().waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
    }

    @Step("Wait for timeout {timeout} seconds")
    public void waitForTimeout(int timeout) {
        page.waitForTimeout(timeout * 1000);
    }

    @Step("Wait for Load State")
    public void waitForLoadState() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void waitForURL(String url) {
        page.waitForURL("**/" + url + "*");
    }

    public boolean verifyURLContains(String url) {
        return page.url().contains("/" + url);
    }

    @Step("Scroll And Click {element.name}")
    public void scrollAndClick(NamedLocator element) {
        Locator locator = element.get();

        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        locator.scrollIntoViewIfNeeded();
        locator.click();
    }

    public void HoverElement(NamedLocator element) {
        Locator locator = element.get();

        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        locator.hover();}
}
