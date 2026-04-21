package com.OrangeHRM.utils;

import com.microsoft.playwright.Locator;
import java.util.ArrayList;
import java.util.List;

public class TableUtils {

    private final Locator table;

    public TableUtils(Locator table) {
        this.table = table;
    }

    private Locator getRows() {
        Locator rows = table.locator("tr.mat-mdc-row");
        rows.first().waitFor();
        return rows;
    }

    private Locator getHeaders() {
        return table.locator("th.mat-mdc-header-cell");
    }

    // 1. Get all data (ALL PAGES)
    public List<List<String>> getAllDataWithPagination(PaginationUtils pagi) {
        List<List<String>> data = new ArrayList<>();

        while (true) {
            data.addAll(getAllData()); // reuse

            if (!pagi.hasNext()) break;

            pagi.goToNextPage();
        }

        return data;
    }

    // 2. Get all data (1 PAGE)
    public List<List<String>> getAllData() {
        List<List<String>> data = new ArrayList<>();

        Locator rows = getRows();

        for (int i = 0; i < rows.count(); i++) {
            List<String> rowData = rows.nth(i)
                    .locator("td")
                    .allInnerTexts()
                    .stream()
                    .map(String::trim)
                    .toList();

            data.add(rowData);
        }

        return data;
    }


    public List<String> getDataByColumnIndexWithPagination(int colIndex, PaginationUtils pagi) {

        List<String> result = new ArrayList<>();

        while (true) {

            Locator rows = getRows();

//            System.out.println("Rows on page: " + rows.count());
//
            for (int i = 0; i < rows.count(); i++) {
                Locator cells = rows.nth(i).locator("td");

                if (cells.count() > colIndex) {
                    result.add(
                            cells.nth(colIndex)
                                    .innerText()
                                    .trim()
                    );
                }
            }

            if (!pagi.hasNext()) {
//                System.out.println("Cannot loop");
                break;
            }
            pagi.goToNextPage();

            getRows().first().waitFor();
        }

        return result;
    }


    public List<String> getDataByColumnNameWithPagination(String columnName, PaginationUtils pagi) {

        List<String> headers = getHeaders()
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .toList();

        int index = -1;

        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).equalsIgnoreCase(columnName.trim())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new RuntimeException("Column not found: " + columnName);
        }
        System.out.println("Index: " +index);
        return getDataByColumnIndexWithPagination(index, pagi);
    }
}