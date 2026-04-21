package com.OrangeHRM.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import java.lang.reflect.Method;
import com.OrangeHRM.annotations.TestCaseId;
import com.OrangeHRM.utils.ScreenshotUtils;
import org.aspectj.lang.reflect.MethodSignature;
@Aspect
public class TestAspect {

    @Before("@annotation(org.testng.annotations.Test)")
    public void beforeTest(JoinPoint joinPoint) {

        try {
            Method method = ((org.aspectj.lang.reflect.MethodSignature)
                    joinPoint.getSignature()).getMethod();

            TestCaseId annotation = method.getAnnotation(TestCaseId.class);

            String testCaseId = (annotation != null)
                    ? annotation.value()
                    : method.getName();

            ScreenshotUtils.setTestCaseId(testCaseId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}