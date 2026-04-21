package com.OrangeHRM.utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class ScreenshotUtils {

    private static ThreadLocal<AtomicInteger> counter =
            ThreadLocal.withInitial(AtomicInteger::new);

    private static ThreadLocal<String> testCaseIdHolder =
            new ThreadLocal<>();

    public static void setTestCaseId(String testCaseId) {
        testCaseIdHolder.set(testCaseId);
        counter.get().set(0);
    }

    public static void takeScreenshot(Page page) {

        String testCaseId = testCaseIdHolder.get();

        int index = counter.get().incrementAndGet();
        String fileName = testCaseId + "-" + index;

        byte[] screenshot = page.screenshot(
                new Page.ScreenshotOptions().setFullPage(true)
        );

        Allure.getLifecycle().addAttachment(
                fileName,
                "image/png",
                "png",
                new ByteArrayInputStream(screenshot)
        );
    }
}