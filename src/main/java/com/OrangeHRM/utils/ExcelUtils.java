package com.OrangeHRM.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getLoginData(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();

            Object[][] data = new Object[rowCount - 1][2];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);

                data[i - 1][0] = getCellValue(row.getCell(1)); // username
                data[i - 1][1] = getCellValue(row.getCell(2)); // password
            }

            workbook.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null)
            return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            default:
                return "";
        }
    }
}