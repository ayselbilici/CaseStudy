package com.webproject.base.step;

import com.thoughtworks.gauge.Step;
import com.webproject.base.base.BasePageUtil;
import org.apache.log4j.Logger;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

import java.util.*;


public class StepImplemention extends BasePageUtil {

    final static Logger logger = Logger.getLogger(StepImplemention.class);

    @Step("<key> elementine tıkla")
    public void clickElement(String key) {
        WebElement element = findElement(key);
        clickToElement(element);
    }

    @Step("<key> saniye bekle")
    public void waitSecond(int second) {
        waitByMilliSeconds(second * 1000);
    }

    @Step("<key> alanına <text> yaz")
    public void sendKeys(String key, String text) {
        findElement(key).sendKeys(text);
    }

    @Step("Yeni sekmeye odaklan")
    public void chromeFocusLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    @Step({"Check element is here <key>"})
    public WebElement checkElementHere(String key) {
        WebElement element;
        try {
            element = findElement(key);
            scrollToElement(element);
            logger.info(key + " element is here.");
        } catch (Exception ex) {
            Assert.fail("Element: '" + key + "' doesn't exist.");
            return null;
        }
        return element;
    }

}

