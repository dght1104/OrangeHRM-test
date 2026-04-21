package com.OrangeHRM.utils;

import org.testng.Assert;

import java.util.List;

public class AssertUtils {

    public void verifyTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public void verifyFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public void verifyEquals(List<String> actual, List<String> expected, String message) {

        if (actual.size() != expected.size()) {
            throw new AssertionError(message +
                    " | Size mismatch. UI: " + actual.size() + " DB: " + expected.size());
        }

        for (int i = 0; i < actual.size(); i++) {

            String uiValue = actual.get(i);
            String dbValue = expected.get(i);

            if (!uiValue.equals(dbValue)) {
                throw new AssertionError(
                        message +
                                " | Mismatch at index " + i +
                                " | UI: " + uiValue +
                                " | DB: " + dbValue
                );
            }
        }
    }
}