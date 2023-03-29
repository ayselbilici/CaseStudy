package com.webproject.base.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import config.YamlProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    YamlProperties yp = new YamlProperties();


    @BeforeScenario
    public void setUp() throws Exception {

        String ENV = System.getProperty("ENV");
        if (ENV == null)
            ENV = "qa";

        String baseUrl = yp.properties().getBaseUrl();

        System.out.println(ENV + " ENV");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("test-type");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 45, 200);
        driver.get(baseUrl);
    }

    @AfterScenario
    public void tearDown() {
        driver.quit();
    }

}
