package com.OrangeHRM.managers;

import com.microsoft.playwright.*;

public class PageManager {
    private static ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Page> pagesThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();

    public static Browser getBrowser() {

        return browserThreadLocal.get();
    }

    public static void setBrowser(Browser browser) {

        browserThreadLocal.set(browser);
    }

    public static void closeBrowser(){
        if(browserThreadLocal.get()!=null){
            browserThreadLocal.get().close();
            browserThreadLocal.remove();
        }
    }

    public static BrowserContext getBrowserContext() {

        return browserContextThreadLocal.get();
    }

    public static void setBrowserContext(BrowserContext browserContext) {

        browserContextThreadLocal.set(browserContext);
    }

    public static void createNewPage() {
        BrowserContext ctx = browserThreadLocal.get().newContext();
        browserContextThreadLocal.set(ctx);
        pagesThreadLocal.set(ctx.newPage());
    }

    public static void closeBrowserContext(){
        if(browserContextThreadLocal.get()!=null){
            browserContextThreadLocal.get().close();
            browserContextThreadLocal.remove();
        }
    }

    public static Playwright getPlaywright() {

        return playwrightThreadLocal.get();
    }

    public static void setPlaywright(Playwright playwright) {

        playwrightThreadLocal.set(playwright);
    }

    public static void closePlaywright(){
        if(playwrightThreadLocal.get()!=null){
            playwrightThreadLocal.get().close();
            playwrightThreadLocal.remove();
        }
    }

    public static Page getPage() {

        return pagesThreadLocal.get();
    }

    public static void setPage(Page page) {

        pagesThreadLocal.set(page);
    }

    public static  void closePage(){
        if(pagesThreadLocal.get()!=null){
            pagesThreadLocal.get().close();
            pagesThreadLocal.remove();
        }
    }

    public static void closeAll(){
        closeBrowserContext();
        closeBrowser();
        closePlaywright();
    }
}
