package com.OrangeHRM.managers;

import com.microsoft.playwright.*;
import java.util.Arrays;
import java.util.List;
import com.OrangeHRM.constants.AppConfig;
import com.microsoft.playwright.options.ViewportSize;

public class BrowserFactory {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    public void createBrowser(String browserName) {
        playwright = Playwright.create();
        PageManager.setPlaywright(playwright);
        boolean headless = AppConfig.HEADLESS;
        switch (browserName.toLowerCase().trim()) {
            case "chromium":
                System.out.println("Create Chromium browser...");
                BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(AppConfig.HEADLESS)
                        .setArgs(Arrays.asList("--no-sandbox", "--ignore-certificate-errors",
                                "--disable-popup-blocking", "--disable-blink-features=BlockCredentialedSubresources",
                                "--auth-server-whitelist=*", "--auth-negotiate-delegate-whitelist=*",
                                "--disable-features=IsolateOrigins,site-per-process", "--start-maximized"))
                        .setSlowMo(500);
                browser = switch (browserName) {
                    case "chrome" -> playwright.chromium().launch(launchOptions.setChannel("chrome"));
                    case "chromium" -> playwright.chromium().launch(launchOptions);
                    case "firefox" -> playwright.firefox().launch(launchOptions);
                    case "webkit" -> playwright.webkit().launch(launchOptions);
                    default -> throw new IllegalArgumentException("Could not Launch Browser for type" + browserName);
                };
                break;
            case "chrome":
                System.out.println("HEADLESS: " + AppConfig.HEADLESS);
                System.out.println("Create Chrome browser...");
                browser = PageManager.getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(AppConfig.HEADLESS).setArgs(List.of("--start-maximized")));
                break;
            case "edge":
                System.out.println("Create Edge browser...");
                browser = PageManager.getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(AppConfig.HEADLESS).setArgs(Arrays.asList("--start-maximized")));
                break;
            case "firefox":
                System.out.println("Create Firefox browser...");
                browser = PageManager.getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(AppConfig.HEADLESS).setArgs(Arrays.asList("--start-maximized")));
                break;
            case "safari":
                System.out.println("Create Safari browser...");
                browser = PageManager.getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(AppConfig.HEADLESS).setArgs(Arrays.asList("--start-maximized")));
                break;
            default:
                System.out.println("Set default Chromium browser...");
                browser = PageManager.getPlaywright().chromium().launch(new BrowserType.LaunchOptions());
                break;
        }

        PageManager.setBrowser(browser);

        String widthViewPort = AppConfig.WIDTH_VIEWPORT;
        String heightViewPort = AppConfig.HEIGHT_VIEWPORT;

        System.out.println("Width ViewPort: " + widthViewPort);
        System.out.println("Height ViewPort: " + heightViewPort);

        ViewportSize viewportSize;
        if (headless) viewportSize = new ViewportSize(Integer.parseInt(widthViewPort), Integer.parseInt(heightViewPort));
        else viewportSize = null;

        BrowserContext context =browser.newContext(new Browser.NewContextOptions()
                .setAcceptDownloads(true)
                .setViewportSize(viewportSize)
                .setScreenSize(Integer.parseInt(widthViewPort), Integer.parseInt(heightViewPort))
                .setIgnoreHTTPSErrors(true));

//        browserContext = PageManager.getBrowser().newContext(new Browser.NewContextOptions());
        PageManager.setBrowserContext(context);

        page = PageManager.getBrowserContext().newPage();
        PageManager.setPage(page);
    }


}