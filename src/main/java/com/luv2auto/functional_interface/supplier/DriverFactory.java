package com.luv2auto.functional_interface.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.EnumMap;
import java.util.function.Supplier;

public final class DriverFactory {
    private static final Supplier<WebDriver> CHROME = ChromeDriver::new;
    private static final Supplier<WebDriver> FIREFOX = FirefoxDriver::new;

    private static final EnumMap<Browser, Supplier<WebDriver>> MAP = new EnumMap<>(Browser.class);

    static {
        MAP.put(Browser.CHROME, CHROME);
        MAP.put(Browser.FIREFOX, FIREFOX);
    }

    private DriverFactory() {
        throw new UnsupportedOperationException("Cannot instantiate this class");
    }

    public static WebDriver getDriver(Browser browser) {
        return MAP.get(browser).get();
    }

}
