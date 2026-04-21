package com.icrm.dto;

import com.microsoft.playwright.Locator;

public record NamedLocator(Locator locator, String name)  {
    public static NamedLocator of(Locator locator, String name) {
        return new NamedLocator(locator, name);
    }

    public NamedLocator first() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'first'");
    }

    public Locator get() {
        return locator;
    }
}