package com.falabela.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartValidationUI {

    public static Target LBL_CARTPRODUCTNAME = Target.the("Nombre del producto en carrito").locatedBy("//a[@class='chakra-link css-qpfo7l']");
    public static Target LBL_CARTQUANTITYPRODUCT = Target.the("Cantidad del producto en carrito").locatedBy("//input[@class='chakra-input css-1k2vvg6']");


}
