package com.falabela.tasks;

import com.falabela.interactions.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.falabela.ui.ProductDetailsUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductDetailsTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String chosenProductName = LBL_CHOSEN_PRODUCTNAME.resolveFor(actor).getText();
        actor.remember("nameProduct", chosenProductName);


        actor.attemptsTo(

                Scroll.down(),
                Click.on(BTN_INCREASEQUANTITY),
                Click.on(BTN_INCREASEQUANTITY),
                Click.on(BTN_ADDTOCART)
        );


        String chosenQuantityProduct = CHOSENPRODUCTQUANTITY.resolveFor(actor).getValue();
        actor.remember("quantityProduct", chosenQuantityProduct);


        actor.attemptsTo(

                Click.on(BTN_GOTOCART)

        );


    }

    public static ProductDetailsTask on() {

        return instrumented(ProductDetailsTask.class);

    }

}
