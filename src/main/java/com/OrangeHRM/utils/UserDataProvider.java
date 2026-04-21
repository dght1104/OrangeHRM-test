package com.icrm.utils;

import java.util.List;

import org.testng.annotations.DataProvider;
import com.icrm.managers.BasePage;
import com.icrm.query.userQuery;
import com.microsoft.playwright.Page;

public class UserDataProvider {
    Page page;
    DatabaseUtils dbUtils =
            new DatabaseUtils(new BasePage(page));

    @DataProvider(name = "UserOfDatabase")
    public Object[][] users() {
        System.out.println("START DP");
        List<String> usernames =
                dbUtils.getUsernamesFromDB(userQuery.getUserNameQuery());

        Object[][] data = new Object[usernames.size()][2];

        for (int i = 0; i < usernames.size(); i++) {
            data[i][0] = usernames.get(i);
            data[i][1] = "123456";
        }

        return data;
    }

    @DataProvider(name = "UserOfExcelData")
    public Object[][] getExcelData() {
        String path = "src/test/resources/credentials.xlsx";
        return ExcelUtils.getLoginData(path, "Sheet1");
    }

}
