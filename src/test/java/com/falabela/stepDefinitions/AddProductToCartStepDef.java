
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


    @Given("that the user open the Falabella page and searches for any product.")
    public void thatTheUserOpenTheFalabellaPageAndSearchesForAnyProduct() {

        theActorCalled("User").wasAbleTo(

                Open.url("https://www.falabella.com.co/"),
                HomeTask.on()

        );

    }

    @When("the user select a product from the list of search results and select the quantity of the product to cart by clicking on Add to cart.")
    public void theUserSelectAProductFromTheListOfSearchResultsAndSelectTheQuantityOfTheProductToCartByClickingOnAddToCart() {

        theActorInTheSpotlight().attemptsTo(

                ProductsCatalogTask.on(),
                ProductDetailsTask.on()

        );


    }


    @Then("the user verifies that the name of the product in the cart is equal to the name of the product selected")
    public void theUserVerifiesThatTheNameOfTheProductInTheCartIsEqualToTheNameOfTheProductSelected() {


        theActorInTheSpotlight().should(

                seeThat(
                        ProductNameValidationQuestion.from(), Matchers.equalTo(true)
                )

        );
    }


    @Then("the user verifies that the quantity of products in the cart is equal to the quantity of the selected product.")
    public void theUserVerifiesThatTheQuantityOfProductsInTheCartIsEqualToTheQuantityOfTheSelectedProduct() {


        theActorInTheSpotlight().should(

                seeThat(

                        ProductQuantityValidationQuestion.from(), Matchers.equalTo(true)
                )

        );

    }

}

