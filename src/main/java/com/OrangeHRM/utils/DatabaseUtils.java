package com.icrm.utils;

import com.icrm.constants.AppConfig;
import com.icrm.managers.BasePage;
import com.microsoft.playwright.Locator;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DatabaseUtils {

    private Connection connection;
    private BasePage basePage;

    public DatabaseUtils(BasePage basePage) {
        this.basePage = basePage;
    }

    // ================= DATABASE CONNECTION =================

    public Connection connectDB() {
        try {

            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(
                        AppConfig.DATASOURCE_URL,
                        AppConfig.DATASOURCE_USERNAME,
                        AppConfig.DATASOURCE_PASSWORD
                );

                System.out.println("Connected to Database");
            }

        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }

        return connection;
    }

    public void closeDBConnection() {

        try {

            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= ROW COUNT =================

    public int getRowCountofTable(String tableName) {

        int count = 0;

        try {

            Connection conn = connectDB();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT COUNT(*) FROM " + tableName
            );

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ================= UI vs DB ROW VERIFY =================

    public boolean verifyUITableMatchesDBTable(String tableId, String dbTableName) {

        int uiRows = basePage.page
                .locator("#" + tableId + " tbody tr")
                .count();

        int dbRows = getRowCountofTable(dbTableName);

        System.out.println("UI rows: " + uiRows);
        System.out.println("DB rows: " + dbRows);

        return uiRows == dbRows;
    }

    // ================= COLUMN HEADERS =================

    public List<String> getColumnNamesOnDB(String tableName) {

        List<String> columns = new ArrayList<>();

        try {

            Connection conn = connectDB();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return columns;
    }

    public List<String> getColumnNamesOnUI(String tableId) {

        return basePage.page
                .locator("#" + tableId + " thead th")
                .allTextContents();
    }

    public boolean verifyHeaderMatchesDB(String tableUI, String tableDb) {

        List<String> uiHeaders = getColumnNamesOnUI(tableUI);
        List<String> dbColumns = getColumnNamesOnDB(tableDb);

        System.out.println("UI headers: " + uiHeaders);
        System.out.println("DB columns: " + dbColumns);

        return uiHeaders.equals(dbColumns);
    }

    // ================= GET VALUES FROM DB =================

    public List<String> getValuesByNameFromDB(String query) {

        List<String> values = new ArrayList<>();

        try {

            Connection conn = connectDB();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {

                    String value = rs.getString(i);

                    if (salutationMap.containsKey(value)) {
                        value = salutationMap.get(value);
                    }

                    if (leadSrcMap.containsKey(value)) {
                        value = leadSrcMap.get(value);
                    }

                    values.add(value);
                }
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }

    public List<String> queryValuesByNameFromDB(String query) {

        List<String> values = new ArrayList<>();

        try (Connection conn = connectDB();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Executing Query: " + query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Column Count: " + columnCount);

            if (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {

                    Object obj = rs.getObject(i);
                    String value;

                    if (obj == null) {
                        value = "";
                    } else if (obj instanceof java.sql.Date) {

                        LocalDate date = ((java.sql.Date) obj).toLocalDate();

                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

                        value = date.format(formatter);
                    } else if (obj instanceof java.sql.Timestamp) {

                        LocalDateTime dateTime =
                                ((java.sql.Timestamp) obj).toLocalDateTime();

                        // convert UTC -> Vietnam time
                        dateTime = dateTime.plusHours(7);

                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern(
                                        "MMM d, yyyy, h:mm:ss a",
                                        Locale.ENGLISH
                                );

                        value = dateTime.format(formatter);
                    } else {
                        value = obj.toString();
                    }

                    values.add(value.trim());
                }

            } else {
                System.out.println("No data found in DB");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("DB Values: " + values);

        return values;
    }

     public List<String> queryValuesEditedByNameFromDB(String query) {

    List<String> values = new ArrayList<>();

    try (Connection conn = connectDB();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        System.out.println("Executing Query: " + query);

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        if (rs.next()) {

            for (int i = 1; i <= columnCount; i++) {

                Object obj = rs.getObject(i);
                String value;

                if (obj == null) {
                    value = "";


                } else if (obj instanceof java.sql.Date) {

                    LocalDate date = ((java.sql.Date) obj).toLocalDate();
                    value = date.format(DateTimeFormatter.ofPattern("M/d/yyyy"));


                } else if (obj instanceof java.sql.Timestamp) {

                    LocalDateTime dateTime =
                            ((java.sql.Timestamp) obj).toLocalDateTime();

                    dateTime = dateTime.plusHours(7);

                    value = dateTime.format(
                            DateTimeFormatter.ofPattern("M/d/yyyy")
                    );

    
                } else if (obj instanceof Integer && obj.toString().length() == 8) {

                    String raw = obj.toString(); // 20150824

                    LocalDate date = LocalDate.parse(
                            raw,
                            DateTimeFormatter.ofPattern("yyyyMMdd")
                    );

                    value = date.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

                } else {
                    value = obj.toString();
                }

                values.add(value.trim());
            }

        } else {
            System.out.println("No data found in DB");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("DB Values: " + values);

    return values;
    }
    // ================= GET VALUES FROM UI =================

    public List<String> getValuesByNameFromUI(String name) {

        Locator row = basePage.page
                .locator("tr:has(td.mat-column-contactName:has-text('" + name + "'))");

        List<String> values = new ArrayList<>();

        values.add(row.locator("td.mat-column-salutation").textContent().trim());
        values.add(row.locator("td.mat-column-leadSrc").textContent().trim());
        values.add(row.locator("td.mat-column-assignedTo").textContent().trim());

        return values;
    }

    // ================= VERIFY UI vs DB =================

    public boolean verifyValuesOnUIMatchDB(String name, String query) {

        List<String> uiValues = getValuesByNameFromUI(name);
        List<String> dbValues = getValuesByNameFromDB(query);

        // System.out.println("UI values: " + uiValues);
        // System.out.println("DB values: " + dbValues);

        return uiValues.equals(dbValues);
    }

    // ================= ENUM MAPPING =================

    Map<String, String> salutationMap = Map.of(
            "0", "None",
            "1", "Mr",
            "2", "Mrs",
            "3", "Ms"
    );

    Map<String, String> leadSrcMap = Map.of(
            "0", "Advertisement",
            "1", "Cold Call",
            "2", "Employee Referral",
            "3", "External Referral",
            "4", "Word of mouth"
    );

    public boolean isRecordExist(String query) {
        boolean exists = false;

        try {
            Connection conn = connectDB();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            exists = rs.next();

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exists;
    }

    public boolean verifyUpdatedContactMatchesDB(String name, String query) {

        List<String> dbValues = getValuesByNameFromDB(query);
        List<String> uiValues = getValuesByNameFromUI(name);

        System.out.println("UI values: " + uiValues);
        System.out.println("DB values: " + dbValues);

        if (uiValues.size() != dbValues.size()) {
            return false;
        }

        for (int i = 0; i < uiValues.size(); i++) {

            String ui = uiValues.get(i).trim();
            String db = dbValues.get(i).trim();

            if (!ui.equals(db)) {

                System.out.println(
                        "Mismatch at column " + i +
                                ": UI=" + ui +
                                " DB=" + db
                );

                return false;
            }
        }

        return true;
    }

    public List<String> getUsernamesFromDB(String query) {

        List<String> usernames = new ArrayList<>();

        try (Connection conn = connectDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usernames;
    }

}

