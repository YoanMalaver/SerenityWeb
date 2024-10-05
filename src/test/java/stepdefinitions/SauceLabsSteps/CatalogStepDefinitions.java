package stepdefinitions.SauceLabsSteps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import starter.models.Product;


import java.util.List;
import java.util.Map;

public class CatalogStepDefinitions {

    @Given("{actor} has logged on to the Application")
    public void on_the_login_page(Actor actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue("standard_user").into(InputField.withPlaceholder("Username")),
                Enter.theValue("secret_sauce").into(InputField.withPlaceholder("Password")),
                Click.on(Button.withNameOrId("Loggin"))
        );
    }

    @DataTableType
    public Product product(Map<String, String> productData) {
        return new Product(productData.get("Title"), productData.get("Price"));
    }

    @Then("she should be presented with the following")
    public void should_be_presented_with_the_following(List<Product> expectedProducts) {

        for (Product product: expectedProducts) {
            System.out.println(product);
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Ensure.that(PageElement.withCSSClass("inventory_item").containingText(product.title())).isDisplayed(),
                    Ensure.that(PageElement.withCSSClass("inventory_item").containingText(product.title())).textContent().contains(product.price())
            );
        }
    }



}
