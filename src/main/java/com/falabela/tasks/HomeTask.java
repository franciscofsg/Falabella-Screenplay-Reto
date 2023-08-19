package com.falabela.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import static com.falabela.ui.HomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.falabela.utils.ExcelDataReader;
import org.openqa.selenium.Keys;
import java.util.Map;


public class HomeTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, String> testData = ExcelDataReader.getMapData("producto"); //  nombre de la hoja excel

        String searchProduct = testData.get("Producto"); //encabezado de columna del Excel

        actor.attemptsTo(

           Enter.theValue(searchProduct).into(TXT_SEARCH).thenHit(Keys.ARROW_DOWN,Keys.ENTER)

        );


    }

    public static HomeTask on() {

        return instrumented(HomeTask.class);

    }


}
