package com.icrm.utils;

import com.microsoft.playwright.Locator;

public class PaginationUtils {

    private final Locator nextButton;
    private final Locator table;

    public PaginationUtils(Locator nextButton, Locator table) {
        this.nextButton = nextButton;
        this.table = table;
    }

    public boolean hasNext() {
        return nextButton.isEnabled();
    }

    public void goToNextPage() {
        nextButton.click();
        table.locator("tr.mat-mdc-row").first().waitFor();
        System.out.println("GO NEXT PAGE");
    }

}