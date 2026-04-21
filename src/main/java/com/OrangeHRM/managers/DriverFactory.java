package com.OrangeHRM.managers;

import com.OrangeHRM.constants.AppConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ViewportSize;
import java.text.MessageFormat;
import java.util.Arrays;

public class DriverFactory {

    public static Browser browser;
    public static final Playwright playwright = Playwright.create();

    //Launches Browser as set by user in config file
    public static BasePage initDriver(String browserName) {
        boolean headless = AppConfig.HEADLESS;
        Browser browser = initBrowser(browserName, headless);
        String widthViewPort = AppConfig.WIDTH_VIEWPORT;
        String heightViewPort = AppConfig.HEIGHT_VIEWPORT;

 //       System.out.println("Width ViewPort: " + widthViewPort);
   //     System.out.println("Height ViewPort: " + heightViewPort);

        ViewportSize viewportSize;
        if (headless)
            viewportSize = new ViewportSize(Integer.parseInt(widthViewPort), Integer.parseInt(heightViewPort));
        else viewportSize = null;

        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setAcceptDownloads(true).setViewportSize(viewportSize)
                .setScreenSize(Integer.parseInt(widthViewPort), Integer.parseInt(heightViewPort)).setIgnoreHTTPSErrors(true).setAcceptDownloads(true));
        return new BasePage(context.newPage(), context);
    }

    public static Browser initBrowser(String browserName, boolean headless) {

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(headless).setArgs(Arrays.asList("--no-sandbox", "--ignore-certificate-errors",
                        "--disable-popup-blocking", "--disable-blink-features=BlockCredentialedSubresources",
                        "--auth-server-whitelist=*", "--auth-negotiate-delegate-whitelist=*",
                        "--disable-features=IsolateOrigins,site-per-process", "--start-maximized")).setSlowMo(500);
        Browser browser = switch (browserName) {
            case "chrome" -> playwright.chromium().launch(launchOptions.setChannel("chrome"));
            case "chromium" -> playwright.chromium().launch(launchOptions);
            case "firefox" -> playwright.firefox().launch(launchOptions);
            case "webkit" -> playwright.webkit().launch(launchOptions);
            default -> throw new IllegalArgumentException("Could not Launch Browser for type" + browserName);
        };
//        System.out.println(MessageFormat.format("{0} - {1} {2}", browser.browserType().name(), browserName, browser.version()));
        return browser;
    }
}
