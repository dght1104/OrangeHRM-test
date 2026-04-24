package OrangeHRM.testcases.base;

import com.OrangeHRM.managers.BasePage;
import com.OrangeHRM.managers.DriverFactory;
import com.OrangeHRM.utils.ScreenshotUtils;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestCase {

    public static BasePage basePage;

    public void initBasePage() {
        basePage = DriverFactory.initDriver("chrome");
    }

    void closeBrowser() {
        basePage.page.close();
    }

    @Step("And: Take Screenshot")
    public void takeScreenshot() {
    ScreenshotUtils.takeScreenshot(basePage.page);
    }


    @BeforeMethod
    public void setUpBaseTest() {
        initBasePage();
    }
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
