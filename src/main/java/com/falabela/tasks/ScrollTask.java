package com.falabela.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollTask implements Task {

    private final int pixelsToScroll;
    private final Target target;

    public ScrollTask(int pixelsToScroll, Target target) {
        this.pixelsToScroll = pixelsToScroll;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", target.resolveFor(actor));
    }

    public static ScrollTask byPixels(int pixelsToScroll, Target target) {
        return instrumented(ScrollTask.class, pixelsToScroll, target);
    }
}
