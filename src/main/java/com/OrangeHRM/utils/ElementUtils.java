package com.OrangeHRM.utils;

import com.OrangeHRM.dto.NamedLocator;
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
        return NamedLocator.of(page.locator("//button[normalize-space()='" + text + "']"), locatorName);
    }

    // ============== Table ==============
    public static NamedLocator tableByText(Page page, String text, String locatorName){
        return NamedLocator.of(page.locator("//table[.//th[contains(text(),'" +text + "')]]"), locatorName);
    }

    //============= PDF File ==============
    public static NamedLocator PDFFileByName(Page page, String Name, String locatorName) {
        return NamedLocator.of(page.locator("//a[contains(., '" + Name + "')]"), locatorName);
    }

    //============= Input Field ==============
    public static NamedLocator inputFieldByName(Page page, String Name, String locatorName) {
        return NamedLocator.of(page.locator("//input[contains(@placeholder, '" + Name + "')]"), locatorName);
    }

    //============= Get Element By Class ==============
    public static NamedLocator elementByClass(Page page, String className, String locatorName) {
        return NamedLocator.of(page.locator("//*[contains(@class, '" + className + "')]"), locatorName);
    }

     //============ Get Element By Class and Tag =============
    public static NamedLocator elementByClassAndTag(Page page, String className, String tagName, String locatorName) {
        return NamedLocator.of(page.locator("//" +tagName+"[contains(@class, '" + className + "')]" ), locatorName);
    }

    //============ Get Element By Class and Text And Tag =============
    public static NamedLocator elementByClassAndTextAndTag(Page page, String tagName,String className, String text, String locatorName) {
        return NamedLocator.of(page.locator("//" +tagName+"[contains(@class, '" + className + "' ) and ( text()= '" + text + "')]"), locatorName);
    }


}
