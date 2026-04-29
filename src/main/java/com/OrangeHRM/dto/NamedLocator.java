package com.OrangeHRM.dto;

import com.microsoft.playwright.Locator;

public record NamedLocator(Locator locator, String name) {
    public static NamedLocator of(Locator locator, String name) {
        return new NamedLocator(locator, name);
    }

    public Locator get() {
        return locator;
    }
}