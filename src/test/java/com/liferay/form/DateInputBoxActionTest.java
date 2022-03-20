package com.liferay.form;

import com.liferay.base.PreparationTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DateInputBoxActionTest extends PreparationTest {
    @Test
    public void dateSelectionTest(){
        webDriver.findElement(By.className("date-picker-dropdown-toggle")).click();

        boolean calendar = webDriver.findElement(By.className("date-picker-dropdown-menu")).isDisplayed();
        Assert.assertEquals(calendar, Boolean.TRUE);

        String previousMonth = "//button[@aria-label=\"Select the previous month\"]";
        String currentDate = "//button[@aria-label=\"Select current date\"]";
        String nextMonth = "//button[@aria-label=\"Select the next month\"]";

        Assert.assertEquals(webDriver.findElement(By.xpath(previousMonth)).isEnabled(), Boolean.TRUE);
        Assert.assertEquals(webDriver.findElement(By.xpath(currentDate)).isEnabled(), Boolean.TRUE);
        Assert.assertEquals(webDriver.findElement(By.xpath(nextMonth)).isEnabled(), Boolean.TRUE);

        webDriver.findElement(By.xpath("//select[@name='year']/option[@value='2022']")).click();
        webDriver.findElement(By.xpath("//select[@name='month']/option[@value='0']")).click();
        webDriver.findElement(By.xpath("//button[@aria-label=\"Sat Jan 01 2022\"]")).click();

        String nameInputBox = "//div[@class=\"col-ddm col-md-7\"]//div//div//div//input";
        String testingAreaInputBox = "//div[@class=\"col-ddm col-md-12\"]//div//div//div//textarea";

        webDriver.findElement(By.xpath(nameInputBox)).sendKeys("test");
        webDriver.findElement(By.xpath(testingAreaInputBox)).sendKeys("test");
        webDriver.findElement(By.id("ddm-form-submit")).click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String submitAgainBtn = "//div[@class=\"lfr-ddm__default-page-buttons\"]//button";
        Assert.assertEquals(webDriver.findElement(By.xpath(submitAgainBtn)).isDisplayed(), Boolean.TRUE);
    }
}
