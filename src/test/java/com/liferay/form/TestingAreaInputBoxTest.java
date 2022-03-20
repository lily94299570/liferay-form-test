package com.liferay.form;

import com.liferay.base.PreparationTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestingAreaInputBoxTest extends PreparationTest {
    @Test
    public void testingAreaInputBoxTest(){
        String nameInputBox = "//div[@class=\"col-ddm col-md-7\"]//div//div//div//input";
        String dateInputBox = "//input[@placeholder=\"__/__/____\"]";
        String testingAreaInputBox = "//div[@class=\"col-ddm col-md-12\"]//div//div//div//textarea";
        String testingAreaValidation= "//div[@class=\"col-ddm col-md-12\"]//div//div//div//span//div";
        String ValidationMsg = "This field is required.";

        webDriver.findElement(By.xpath(nameInputBox)).sendKeys("test");
        webDriver.findElement(By.xpath(dateInputBox)).sendKeys("01012020");

        webDriver.findElement(By.xpath(testingAreaInputBox)).sendKeys("");
        webDriver.findElement(By.id("ddm-form-submit")).click();

        Assert.assertEquals(webDriver.findElement(By.id("ddm-form-submit")).isDisplayed(), Boolean.TRUE);
        Assert.assertEquals(webDriver.findElement(By.xpath(testingAreaValidation)).getText(),ValidationMsg);

        webDriver.findElement(By.xpath(testingAreaInputBox)).sendKeys("09azAZ.!@#$");
        webDriver.findElement(By.id("ddm-form-submit")).click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String submitAgainBtn = "//div[@class=\"lfr-ddm__default-page-buttons\"]//button";
        Assert.assertEquals(webDriver.findElement(By.xpath(submitAgainBtn)).isDisplayed(), Boolean.TRUE);
    }
}
