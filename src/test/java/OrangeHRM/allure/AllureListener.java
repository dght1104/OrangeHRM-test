package icrm.allure;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.icrm.allure.AllureLogger;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import static com.icrm.allure.AllureLogger.DEFAULT_LOG_LEVEL;

public class AllureListener implements StepLifecycleListener, TestLifecycleListener, ITestListener {
    private AllureLogger logger = new AllureLogger(AllureListener.class);

    public static final ThreadLocal<String> THREAD_LOCAL_TC_NAME = new ThreadLocal<>();
    public static final ThreadLocal<String> THREAD_LOCAL_TC_ID = new ThreadLocal<>();

    @Override
    public void beforeTestStart(TestResult result) {
        THREAD_LOCAL_TC_NAME.set(result.getName());
    }

    public static synchronized String getTestCastName() {
        return THREAD_LOCAL_TC_NAME.get();
    }

    public static synchronized String getTestCaseId() {
        return THREAD_LOCAL_TC_ID.get();
    }

    /**
     * Gets the suite name from the first test method in the test context.
     *
     * @param context the test context
     * @return the suite name
     */
    public static String getSuiteName(ITestContext context) {
        String fullClassName = context.getAllTestMethods()[0].getTestClass().getName();
        String packageName = fullClassName.substring(0, fullClassName.lastIndexOf('.'));
        // Suite name is the last part of the package name
        return packageName.substring(packageName.lastIndexOf('.') + 1);
    }


    @Override
    public void afterStepStop(StepResult stepResult) {
        reformatStepName(stepResult);
        StepLifecycleListener.super.afterStepStop(stepResult);
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("\n ============== Test Cases Run Completed ==============");
    }

    public void reformatStepName(StepResult result) {
        String logLevel;
        String stepDescription = result.getDescription();

        if (Objects.nonNull(stepDescription) && stepDescription.contains(DEFAULT_LOG_LEVEL)) {
            logLevel = DEFAULT_LOG_LEVEL;
        } else {
            logLevel = switch (result.getStatus()) {
                case null -> DEFAULT_LOG_LEVEL;
                case PASSED, FAILED, BROKEN, SKIPPED -> result.getStatus().name();
            };
        }

        String formattedName = MessageFormat.format("{0,dtf_datetime,yyyy-MM-dd HH:mm:ss} | {1} | {2}", LocalDateTime.now(ZoneId.systemDefault()), logLevel, result.getName());
        result.setName(formattedName);
    }
}
