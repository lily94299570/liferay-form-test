package com.liferay.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class PreparationTest {
    @AfterClass
    public  void closeEnv(){
        webDriver.quit();
    }

    @BeforeClass
    public void setUpEnv() throws InterruptedException {
        Path p1 = Paths.get("src","drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver webDriver;

}
