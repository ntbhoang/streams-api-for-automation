package com.luv2auto.stream;

import com.luv2auto.functional_interface.supplier.Browser;
import com.luv2auto.functional_interface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.image.ImageProducer;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class GoogleLinkStreamTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        if (Objects.isNull(driver))
            driver = DriverFactory.getDriver(Browser.FIREFOX);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
    }


    @AfterMethod
    public void tearDown() {
        if (Objects.nonNull(driver)) driver.quit();
    }

    @Test
    public void testGoogleLinkStream() {
       List<WebElement> links = driver.findElements(By.tagName("a"));

       links.stream()
               .map(WebElement::getText)
               .map(String::trim)
               .filter(text -> !text.isEmpty())
               .filter(text -> text.contains("abcddwqetuytiiyuiluiumhgnfazsgddfhfdghjghfkABCDERTGHYYUUIOPSALH"))
               .map(String::toUpperCase)
               .forEach(System.out::println);
    }
}
