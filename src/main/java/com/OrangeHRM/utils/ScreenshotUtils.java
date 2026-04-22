package com.OrangeHRM.utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Files;
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

    if (page == null) {
        System.out.println("Page is null, cannot take screenshot");
        return;
    }

    String testCaseId = testCaseIdHolder.get();
    if (testCaseId == null) testCaseId = "NO_TC_ID";

    int index = counter.get().incrementAndGet();

    String time = new SimpleDateFormat("HHmmss").format(new Date());
    String fileName = testCaseId + "-" + index + "-" + time + ".png";

    try {
        String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Path folderPath = Paths.get("screenshots", dateFolder);

        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        Path filePath = folderPath.resolve(fileName);

        byte[] screenshot = page.screenshot(
                new Page.ScreenshotOptions()
                        .setFullPage(true)
                        .setPath(filePath)
        );

        Allure.getLifecycle().addAttachment(
                fileName,
                "image/png",
                "png",
                new ByteArrayInputStream(screenshot)
        );

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}