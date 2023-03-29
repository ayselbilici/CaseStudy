package com.webproject.base.step;

import com.thoughtworks.gauge.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;


public class AboutUs extends StepImplemention {

    private final By aboutUs_list= By.cssSelector("div.css-chjio1 > div:nth-child(1)");

    @Step({"<key> listesindeki elementlerden rastgele bir tanesine tıkla"})
    public void clickElementRandom(String key) {
        List<WebElement> elementList = driver.findElements(aboutUs_list);
        Random rnd = new Random();
        WebElement element = elementList.get(rnd.nextInt(elementList.size()));
        clickToElement(element);
    }

}

