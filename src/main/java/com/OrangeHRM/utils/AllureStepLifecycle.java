package com.OrangeHRM.utils;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AllureStepLifecycle implements StepLifecycleListener {

    private static final Logger log = LoggerFactory.getLogger(AllureStepLifecycle.class);

    @Override
    public void afterStepStop(StepResult result) {

        if (result.getName() == null) return;

        String stepName = result.getName();
        String className = null;

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {

            String name = element.getClassName();

            if (name.startsWith("OrangeHRM.") && !name.contains("AllureStepLifecycle")) {
                int lastDot = name.lastIndexOf(".");
                className = name.substring(0, lastDot); // lấy package

                break;
            }
        }

        Logger stepLogger = LoggerFactory.getLogger(className);

        if (result.getStatus() == Status.PASSED) {
            stepLogger.info(stepName);
        } else if (result.getStatus() == Status.FAILED) {
            stepLogger.error(stepName);
        }

        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String status = result.getStatus() == Status.PASSED ? "PASS"
                : result.getStatus() == Status.FAILED ? "FAIL"
                : "BROKEN";

        result.setName(time + " | " + status + " | " + stepName);
    }
}