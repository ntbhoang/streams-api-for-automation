package com.luv2auto.stream;

import com.google.common.util.concurrent.Uninterruptibles;
import com.luv2auto.functional_interface.supplier.Browser;
import com.luv2auto.functional_interface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class CheckBoxSelectionStreamTest {


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

    @Test(dataProvider = "gender")
    public void testGoogleLinkStream(String gender) throws InterruptedException {

        String maleChkBoxLocators =
                String.format("//tr//td[.='%s']//following-sibling::td//following-sibling::td//input", gender);

        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(tds -> tds.size() == 4)
                .filter(tds -> tds.get(1).getText().equalsIgnoreCase(gender))
                .map(tds -> tds.get(3))
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);


        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    @DataProvider(name = "gender")
    public Object[] genderData() {
        return new Object[] {
                "male",
                "female"
        };
    }
}
