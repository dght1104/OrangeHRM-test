package icrm.testcases.base;

import com.icrm.managers.BasePage;
import com.icrm.managers.DriverFactory;
import com.icrm.utils.ScreenshotUtils;
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
    public void TakeScreenshot(){
        ScreenshotUtils screenshot;
        screenshot = new ScreenshotUtils();
        basePage.page.waitForTimeout(5);
        screenshot.TakeScreenshot(basePage.page);
    }

    @BeforeMethod
    public void setUpBaseTest() {
         initBasePage();
        
    }
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    // @BeforeClass
    // public void setup() {
    //     AuthService auth = new AuthService();

    //     String code = AppConfig.CODE;

    //     auth.initToken(code);
    // }

}
