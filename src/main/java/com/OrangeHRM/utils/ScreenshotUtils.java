package com.OrangeHRM.utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

    public void TakeScreenshot(Page page) {

        if (page == null) {
            System.out.println("Page is null - cannot take screenshot");
            return;
        }

        byte[] screenshot = page.screenshot(
                            new Page.ScreenshotOptions().setFullPage(true));

        Allure.getLifecycle().addAttachment(
                timeStamp,
                "image/png",
                "png",
                new ByteArrayInputStream(screenshot)
            );
    }
}