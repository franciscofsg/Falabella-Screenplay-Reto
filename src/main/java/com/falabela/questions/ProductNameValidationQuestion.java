package com.falabela.questions;

import com.falabela.ui.CartValidationUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductNameValidationQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        String aux = actor.recall("nameProduct");
        String cartProductName = CartValidationUI.LBL_CARTPRODUCTNAME.resolveFor(actor).getText();
        return aux.equals(cartProductName);
    }

    public static Question<Boolean> from() {
        return new ProductNameValidationQuestion();
    }
}
