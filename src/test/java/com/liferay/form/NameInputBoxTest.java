package com.liferay.form;


import com.liferay.base.PreparationTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NameInputBoxTest extends PreparationTest {

    @Test
    public void nameInputBoxTest(){
        String nameInputBox = "//div[@class=\"col-ddm col-md-7\"]//div//div//div//input";
        String dateInputBox = "//input[@placeholder=\"__/__/____\"]";
        String testingAreaInputBox = "//div[@class=\"col-ddm col-md-12\"]//div//div//div//textarea";
        String nameValidation= "//div[@class=\"col-ddm col-md-7\"]//div//div//div//span//div";
        String ValidationMsg = "This field is required.";

        webDriver.findElement(By.xpath(dateInputBox)).sendKeys("01012020");
        webDriver.findElement(By.xpath(testingAreaInputBox)).sendKeys("test");

        webDriver.findElement(By.xpath(nameInputBox)).sendKeys("");
        webDriver.findElement(By.id("ddm-form-submit")).click();

        Assert.assertEquals(webDriver.findElement(By.id("ddm-form-submit")).isDisplayed(), Boolean.TRUE);
        System.out.println(webDriver.findElement(By.xpath(nameValidation)).getText());
        Assert.assertEquals(webDriver.findElement(By.xpath(nameValidation)).getText(),ValidationMsg);

        webDriver.findElement(By.xpath(nameInputBox)).sendKeys("09azAZ.!@#$");
        webDriver.findElement(By.id("ddm-form-submit")).click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String submitAgainBtn = "//div[@class=\"lfr-ddm__default-page-buttons\"]//button";
        Assert.assertEquals(webDriver.findElement(By.xpath(submitAgainBtn)).isDisplayed(), Boolean.TRUE);
    }
}
