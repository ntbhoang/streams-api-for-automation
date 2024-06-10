package com.luv2auto.consumer;

import com.luv2auto.functional_interface.supplier.Browser;
import com.luv2auto.functional_interface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class ConsumerShowLinkTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        if (Objects.isNull(driver)) {
            driver = DriverFactory.getDriver(Browser.CHROME);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.get("https://www.google.com");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (Objects.nonNull(driver)) driver.quit();
    }

    @Test
    public void testShowLinkText() {
        driver.findElements(By.tagName("a")).forEach(e -> {
            System.out.println(e.getText());
        });
        // Assert.assertEquals(driver.getTitle(), "Google");
    }
}
