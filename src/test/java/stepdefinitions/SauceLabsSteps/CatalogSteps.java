package stepdefinitions.SauceLabsSteps;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.models.Users;
import navigation.NavigateTo;
import starter.questions.CartQuestions;
import starter.task.SauceLabs.Login;
import starter.task.SauceLabs.AddToCart;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CatalogSteps {

    @Given("{actor} has logged on to the application")
    public void on_the_login_page(Actor actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                Login.asA(Users.STANDARD_USER)
        );
    }

    @And("he is browsing the catalog")
    public void IsBrowsingTheCatalog() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateTo.toTheCatalog()
        );
    }

    List<String> cartItems;

    @When("he adds the following items to the card:")
    public void AddsTheFollowingItemsToTheCard(List<String> items) {
        cartItems = items;

        items.forEach(
                itemName -> OnStage.theActorInTheSpotlight().attemptsTo(
                        AddToCart.item(itemName)
                )
        );

    }

    @Then("the shopping cart count should be {int}")
    public void theShoppingCartCountShouldBe(int expectedCount) {
        theActorInTheSpotlight().attemptsTo(
                /*Ensure.that(Text.of(".shopping_cart_badge"))
                        .asAnInteger().isEqualTo(expectedCount)
                 */
                Ensure.that(
                        CartQuestions.CurrenlyDisplayed()).isEqualTo(expectedCount)
        );
    }

    @And("the item should appear in the cart")
    public void theItemShouldAppearInTheCart() {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.toTheshoppingCart(),
                //Ensure.that(Text.ofEach(".inventory_item_name")).containsElementsFrom(cartItems)
                Ensure.that(CartQuestions.CurrenlyCartContents()).containsElementsFrom(cartItems)
        );
    }
}
