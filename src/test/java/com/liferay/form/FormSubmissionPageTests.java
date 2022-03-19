package com.liferay.form;

import com.liferay.base.Messages;
import com.liferay.base.PreparationTest;
import com.liferay.base.ValidationMsg;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormSubmissionPageTests extends PreparationTest {
    Path p2 = Paths.get("src","test-resources");
    String testResources = p2.toAbsolutePath().toString();

    @Test
    public void checktextBoxName() throws InterruptedException {
        File csv = new File(testResources, "submission-page-text-box.csv");
        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.className(msg.getCondition())).getText(), msg.getValue());
        }

        webDriver.findElement(By.className("direction-left-side")).click();
        webDriver.findElement(By.className("dropdown-menu-left-side")).click();
        Thread.sleep(2000);

        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.className(msg.getCondition())).getText(), msg.getPTValue());
        }

        webDriver.findElement(By.className("direction-left-side")).click();
        webDriver.findElement(By.className("dropdown-menu-left-side")).click();
        Thread.sleep(2000);
    }

    @Test
    public void checkInputBoxName() throws InterruptedException {
        File csv = new File(testResources, "submission-page-input-box.csv");
        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.xpath(msg.getCondition())).getText(), msg.getValue());
        }

        webDriver.findElement(By.className("direction-left-side")).click();
        webDriver.findElement(By.className("dropdown-menu-left-side")).click();
        Thread.sleep(2000);

        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.xpath(msg.getCondition())).getText(), msg.getPTValue());
        }

        webDriver.findElement(By.className("direction-left-side")).click();
        webDriver.findElement(By.className("dropdown-menu-left-side")).click();
        Thread.sleep(2000);
    }

    @Test
    public void checkBtnName() throws InterruptedException {
        File csv = new File(testResources, "submission-page-button.csv");
        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.className(msg.getCondition())).getText(), msg.getValue());
        }

        webDriver.findElement(By.className("direction-left-side")).click();
        webDriver.findElement(By.className("dropdown-menu-left-side")).click();
        Thread.sleep(2000);

        for (Messages msg : ValidationMsg.getValidationMsgs(csv)) {
            Assert.assertEquals(webDriver.findElement(By.className(msg.getCondition())).getText(), msg.getPTValue());
        }

        webDriver.findElement(By.className("direction-left-side")).click();
        webDriver.findElement(By.className("dropdown-menu-left-side")).click();
        Thread.sleep(2000);
    }
}
