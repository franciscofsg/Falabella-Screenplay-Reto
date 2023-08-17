package com.falabela.stepDefinitions;

import com.falabela.questions.ProductNameValidationQuestion;
import com.falabela.questions.ProductQuantityValidationQuestion;
import com.falabela.tasks.HomeTask;
import com.falabela.tasks.ProductDetailsTask;
import com.falabela.tasks.ProductsCatalogTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AddProductToCartStepDef {

    @Before
    public void setStage() {

        setTheStage(new OnlineCast());

    }

    @Given("that user open the page Falabela and search any product")
    public void thatUserOpenThePageFalabelaAndSearchAnyProduct() {

        theActorCalled("User").wasAbleTo(

                Open.url("https://www.falabella.com.co/"),
                HomeTask.on()

        );


    }
    @When("user click on product tittle and user click on add to cart")
    public void userClickOnProductTittleAndUserClickOnAddToCart() {

        theActorInTheSpotlight().attemptsTo(

                ProductsCatalogTask.on(),
                ProductDetailsTask.on()

        );

    }
    @Then("the user can read the product name from excel.")
    public void theUserCanReadTheProductNameFromExcel() {

        theActorInTheSpotlight().should(

                seeThat(
                        ProductNameValidationQuestion.from(), Matchers.equalTo(true)
                ),


                seeThat(
                        ProductQuantityValidationQuestion.from(), Matchers.equalTo(true)
                )


        );
    }

}
