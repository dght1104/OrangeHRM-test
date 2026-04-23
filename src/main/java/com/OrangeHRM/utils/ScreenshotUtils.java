package com.OrangeHRM.utils;

import com.OrangeHRM.annotations.TestCaseId;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import java.lang.reflect.Method;
import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import org.testng.ITestResult;
import org.testng.Reporter;
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

    String testCaseId = "Unknown";

try {
    ITestResult result = Reporter.getCurrentTestResult();
    if (result != null) {

        Method method = result.getMethod().getConstructorOrMethod().getMethod();

        if (method.isAnnotationPresent(TestCaseId.class)) {
            TestCaseId annotation = method.getAnnotation(TestCaseId.class);
            testCaseId = annotation.value(); // 🔥 lấy TCID
        } else {
            testCaseId = result.getMethod().getMethodName(); // fallback
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}


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