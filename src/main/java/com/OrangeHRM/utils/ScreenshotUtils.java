package com.OrangeHRM.utils;

import com.OrangeHRM.annotations.TestCaseId;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.lang.reflect.Method;
import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Map;

public class ScreenshotUtils {

    private static Map<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();

    private static ThreadLocal<String> testCaseIdHolder =
            new ThreadLocal<>();

    public static void setTestCaseId(String testCaseId) {
        testCaseIdHolder.set(testCaseId);

        // reset counter theo TCID
        counterMap.put(testCaseId, new AtomicInteger(0));
    }

    public static void takeScreenshot(Page page) {

        if (page == null) {
            System.out.println("Page is null, cannot take screenshot");
            return;
        }

        String testCaseId;

        try {
            ITestResult result = Reporter.getCurrentTestResult();

            Method method = result.getMethod()
                    .getConstructorOrMethod()
                    .getMethod();

            TestCaseId annotation = method.getAnnotation(TestCaseId.class);

            if (annotation == null || annotation.value().isEmpty()) {
                throw new RuntimeException(
                        "Missing @TestCaseId on method: " + method.getName()
                );
            }

            testCaseId = annotation.value();

        } catch (Exception e) {
            throw new RuntimeException("Cannot get TestCaseId", e);
        }

        AtomicInteger counter =
                counterMap.computeIfAbsent(testCaseId, k -> new AtomicInteger(0));

        int index = counter.incrementAndGet();

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