package OrangeHRM.listeners;

import org.testng.ITestResult;

import com.OrangeHRM.utils.ScreenshotUtils;

public class TestListener {
     public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ScreenshotUtils.setTestCaseId(testName);
    }
}
