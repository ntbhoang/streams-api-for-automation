package com.luv2auto.stream;

import com.luv2auto.functional_interface.supplier.Browser;
import com.luv2auto.functional_interface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.LinkUtil;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VerifyBrokenLinksTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        if (Objects.isNull(driver))
            driver = DriverFactory.getDriver(Browser.FIREFOX);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

    }


    @AfterTest
    public void tearDown() {
        if (Objects.nonNull(driver)) driver.quit();
    }

    @Test
    public void testBrokenLinksWithSrcAttr() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        boolean result = driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .anyMatch(src -> LinkUtil.getResponseCode(src) != 200);
                //.forEach(src -> System.out.println(src + "---->" + LinkUtil.getResponseCode(src)));
        Assert.assertFalse(result, "Some of the links are broken");
    }

    @Test
    public void testBrokenLinksUsingCollect() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<String> result = driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());
        //.forEach(src -> System.out.println(src + "---->" + LinkUtil.getResponseCode(src)));
        Assert.assertEquals(result.size(), 0, "Some of the links are broken");
    }

    @Test
    public void testBrokenLinksWithHrefAttr() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .map(e -> e.getAttribute("href"))
                .forEach(src -> System.out.println(src + "---->" + LinkUtil.getResponseCode(src)));
    }
}
