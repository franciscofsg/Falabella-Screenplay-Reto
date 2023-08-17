package com.falabela.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import static com.falabela.ui.ProductsCatalogUI.LBL_NAME_PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandom implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

     List<WebElementFacade> listProducts  = LBL_NAME_PRODUCTS.resolveAllFor(actor);
     Random random = new Random();
     int indexRandom =  Math.abs(random.nextInt(listProducts.size()));
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",  listProducts.get(indexRandom).getElement());

     listProducts.get(indexRandom).click();

    }


    public static Performable click() {

        return instrumented(ClickRandom.class);

    }

}
