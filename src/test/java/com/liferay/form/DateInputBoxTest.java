package com.liferay.form;

import com.liferay.base.PreparationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DateInputBoxTest extends PreparationTest {
    @Test
    public void DateInputBoxTest() throws InterruptedException {
        String nameInputBox = "//div[@class=\"col-ddm col-md-7\"]//div//div//div//input";
        String dateInputBox = "//input[@placeholder=\"__/__/____\"]";
        String testingAreaInputBox = "//div[@class=\"col-ddm col-md-12\"]//div//div//div//textarea";
        String nameValidation= "//div[@class=\"col-ddm col-md-5\"]//div//div//div//span//div";
        String ValidationMsg = "This field is required.";

        webDriver.findElement(By.xpath(nameInputBox)).sendKeys("test");
        webDriver.findElement(By.xpath(testingAreaInputBox)).sendKeys("test");

        String[] dateValue = new String[]{"", "!@#$%^", "aabbcc", "0101", "13012020", "01322020"};
        for (int i=0; i<dateValue.length; i++) {
            webDriver.findElement(By.xpath(dateInputBox)).sendKeys(dateValue[i]);
            webDriver.findElement(By.id("ddm-form-submit")).click();

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Assert.assertEquals(webDriver.findElement(By.id("ddm-form-submit")).isDisplayed(), Boolean.TRUE);
            Assert.assertEquals(webDriver.findElement(By.xpath(nameValidation)).getText(), ValidationMsg);

            webDriver.findElement(By.xpath(dateInputBox)).sendKeys(Keys.CONTROL, "a");
            webDriver.findElement(By.xpath(dateInputBox)).sendKeys(Keys.chord(Keys.DELETE));
        }

        webDriver.findElement(By.xpath(dateInputBox)).sendKeys("01012020");
        webDriver.findElement(By.id("ddm-form-submit")).click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String submitAgainBtn = "//div[@class=\"lfr-ddm__default-page-buttons\"]//button";
        Assert.assertEquals(webDriver.findElement(By.xpath(submitAgainBtn)).isDisplayed(), Boolean.TRUE);
    }
}
