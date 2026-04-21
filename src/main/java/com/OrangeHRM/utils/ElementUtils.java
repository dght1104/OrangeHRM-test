package com.icrm.utils;

import com.icrm.dto.NamedLocator;
import com.icrm.managers.BasePage;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ElementUtils {

    // ============== ID =============='
    public static NamedLocator elementById(Page page, String id, String locatorName) {
        return NamedLocator.of(page.locator("//*[@id='" + id + "']"), locatorName);
    }

    // ============== Text =============='
    public static NamedLocator elementByText(Page page, String text, String locatorName){
        return NamedLocator.of(page.locator("//*[contains(text(), '" + text + "')]"),locatorName);
    }

    // ============== Text Button ==============
    public static NamedLocator elementBtnByText(Page page, String text, String locatorName) {
        return NamedLocator.of(page.locator("//button//*[normalize-space()='" + text + "']"), locatorName);
    }

    // ============== Table ==============
    public static NamedLocator tableByText(Page page, String text, String locatorName){
        return NamedLocator.of(page.locator("//table[.//th[contains(text(),'" +text + "')]]"), locatorName);
    }

    // ============== Name ==============
    public static NamedLocator elementByName(Page page, String Name, String locatorName) {
        return NamedLocator.of(page.locator("//*[contains(text(),'" + Name + "')]"), locatorName);
    }

    public static NamedLocator PDFFileByName(Page page, String Name, String locatorName) {
        return NamedLocator.of(page.locator("//a[contains(., '" + Name + "')]"), locatorName);
    }
}
