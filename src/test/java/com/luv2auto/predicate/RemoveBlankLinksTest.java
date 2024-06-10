package com.luv2auto.predicate;

import com.luv2auto.functional_interface.predicate.Rules;
import com.luv2auto.functional_interface.supplier.Browser;
import com.luv2auto.functional_interface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class RemoveBlankLinksTest {
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
    public void testRemoveBlankLinks() {
        BiConsumer<Integer, WebElement> displayIndexLink = (index, e) -> {
            System.out.println(index + " -> " + e.getText());
        };

        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.removeIf(Rules.getRule("isNotEnglishLink"));

        links.forEach(e -> displayIndexLink.accept(links.indexOf(e) + 1, e));
    }
}
