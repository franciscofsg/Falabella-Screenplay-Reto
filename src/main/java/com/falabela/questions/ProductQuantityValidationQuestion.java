
package com.falabela.questions;

import com.falabela.ui.CartValidationUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductQuantityValidationQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        String aux = actor.recall("quantityProduct");
        String cartQuantityProduct = CartValidationUI.LBL_CARTQUANTITYPRODUCT.resolveFor(actor).getValue();
        return aux.equals(cartQuantityProduct);

    }

    public static Question<Boolean> from() {
        return new  ProductQuantityValidationQuestion();
    }
}
