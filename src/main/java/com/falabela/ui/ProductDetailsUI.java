package com.falabela.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailsUI {

   public static Target CHOSENPRODUCTQUANTITY = Target.the("Cantidad elegida del producto").locatedBy("//input[@id='quantity-selector-increment-input']");
    public static Target BTN_INCREASEQUANTITY = Target.the("Boton cantidad de unidades del producto").locatedBy("//button[@class='jsx-152403661 increment btn-primary increment-desktop']");
    public static Target BTN_ADDTOCART = Target.the("Agregar al carrito").locatedBy("//button[@class='jsx-2166277967 button button-mkp-primary button-mkp-primary-xtra-large']");
    public static Target BTN_GOTOCART = Target.the("Ir al carrito").locatedBy("//a[@id='linkButton']");
    public static Target LBL_CHOSEN_PRODUCTNAME = Target.the("Nombre del producto elegido").locatedBy("//section[@id='product-b2c-ui']//h1");    //section[@id='product-b2c-ui']//h1"}

}
