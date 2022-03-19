package com.liferay.form;

import com.liferay.base.Messages;
import com.liferay.base.PreparationTest;
import com.liferay.base.ValidationMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormResultPageTests extends PreparationTest {
    Path p2 = Paths.get("src","test-resources");
    String testResources = p2.toAbsolutePath().toString();

    @Test
    public void checktextBoxName() throws InterruptedException {
        String nameInputBox = "//div[@class=\"col-ddm col-md-7\"]//div//div//div//input";
        String dateInputBox = "//input[@placeholder=\"__/__/____\"]";
        String testingArea = "//div[@class=\"col-ddm col-md-12\"]//div//div//div//textarea";

        webDriver.findElement(By.xpath(nameInputBox)).sendKeys("test");
        webDriver.findElement(By.xpath(dateInputBox)).sendKeys("01012020");
        webDriver.findElement(By.xpath(testingArea)).sendKeys("test");
        webDriver.findElement(By.id("ddm-form-submit")).click();
        Thread.sleep(3000);

        File csv = new File(testResources, "result-page-text-box.csv");
        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.className(msg.getCondition())).getText(), msg.getValue());
        }
    }
}
