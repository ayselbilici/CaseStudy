package com.webproject.base.base;

import config.YamlProperties;
import org.junit.Before;

public class BasePageTest extends YamlProperties {
    @Before
    public static String getEnv() {
        String ENV = System.getProperty("ENV");
        if (ENV == null)
            ENV = "qa";
        return ENV;
    }
}
