package com.luv2auto.functional_interface.predicate;

import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.function.Predicate;

public final class Rules {

    private static final Predicate<WebElement> isBlankLink = e -> e.getText().trim().isEmpty();
    private static final Predicate<WebElement> isNotEnglishLink = e -> !e.getText().trim().matches("[a-zA-Z]+");
    private static final Predicate<WebElement> isContainsG = e -> e.getText().toLowerCase().contains("g");
    private static final Map<String, Predicate<WebElement>> MAP =
            Map.of("isBlankLink", isBlankLink, "isNotEnglishLink", isNotEnglishLink, "isContainsG", isContainsG);

    private Rules() {}

    public static Predicate<WebElement> getRule(String rule) {
        return MAP.get(rule);
    }
}
