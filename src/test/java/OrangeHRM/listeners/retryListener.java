package icrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryListener implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxRetry = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetry) {
            count++;
            return true;
        }
        return false;
    }

    // try-catch block



}
