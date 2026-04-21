package com.OrangeHRM.constants;

import com.OrangeHRM.helper.PropertiesHelper;

public class AppConfig {

    public static final String WIDTH_VIEWPORT = PropertiesHelper.getValue("web.viewport.width");
    public static final String HEIGHT_VIEWPORT = PropertiesHelper.getValue("web.viewport.height");
    public static String BASEURL = PropertiesHelper.getValue("BASEURL");
    public static String DATASOURCE_URL = PropertiesHelper.getValue("datasource_url");
    public static String DATASOURCE_USERNAME = PropertiesHelper.getValue("datasource_username");
    public static String DATASOURCE_PASSWORD = PropertiesHelper.getValue("datasource_password");
    public static String CODE = PropertiesHelper.getValue("code");
    public static boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("headless"));
}