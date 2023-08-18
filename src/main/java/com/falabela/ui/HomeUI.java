package com.falabela.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public static Target TXT_SEARCH = Target.the("Textbox search").locatedBy("//input[@id='testId-SearchBar-Input']");

    public static Target ICON_SEARCH = Target.the("Icon search").locatedBy("//img[@class='SearchBar-module_searchIcon__FS7b4']");

}
