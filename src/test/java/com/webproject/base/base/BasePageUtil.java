package com.webproject.base.base;

import com.webproject.base.helper.ElementHelper;
import com.webproject.base.helper.StoreHelper;
import com.webproject.base.model.ElementInfo;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageUtil extends BaseTest {

    public WebDriverWait wait = new WebDriverWait(driver, 20);
    final static Logger logger = Logger.getLogger(BasePageUtil.class);

    public WebElement findElement(String key) {

        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By by = ElementHelper.getElementInfoToBy(elementInfo);

        try {
            logger.info("findElement method called:  finding " + key);
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception ex) {
            logger.error(key + " element can not find! " + by.toString());
            throw ex;
        }
    }

    public List<WebElement> findElements(String key) {

        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By by = ElementHelper.getElementInfoToBy(elementInfo);
        List<WebElement> elements = null;

        try {
            logger.info("findElements method called:  finding " + key);
            waitSecond(5);
            elements = driver.findElements(by);
        } catch (Exception ex) {
            logger.error(key + " elements can not find! " + by.toString());
            throw ex;
        }
        return elements;
    }

    public void scrollToElement(WebElement element) {
        logger.info("scrollToElement method called:  scrolling to: " + element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", element);
    }

    public void clickToElement(WebElement element) {
        try {
            scrollToElement(element);
            logger.info("clickElement method called:  clicking " + element);
            element.click();
        } catch (
                Exception ex) {
            logger.error(element + " element can not clicked!");
            throw ex;
        }

    }


    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void waitSecond(int second) {
        waitByMilliSeconds(second * 1000);
    }

}

