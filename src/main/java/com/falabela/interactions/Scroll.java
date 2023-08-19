package com.falabela.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (actor.abilityTo(BrowseTheWeb.class) != null) {
            BrowseTheWeb browseTheWeb = actor.abilityTo(BrowseTheWeb.class);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) browseTheWeb.getDriver();

            String scrollScript = "window.scrollBy(0, 200);";
            jsExecutor.executeScript(scrollScript);
        }


    }

    public static Scroll down() {
        return new Scroll();
    }
}