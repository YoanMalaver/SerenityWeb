package stepdefinitions.SauceLabsSteps;


import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import starter.models.Users;
import starter.task.SauceLabs.Login;

public class AuthenticationSteps {

    @Given("{actor} is on the login page")
    public void on_the_login_page(Actor actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }
    @When("Colin logs in with valid credentials")
    public void logs_in_with_valid_credentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.asA(Users.STANDARD_USER)
        );
    }
    @Then("she should be presented with the product catalog")
    public void should_be_presented_with_the_product_catalog() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(".title")).isEqualToIgnoringCase("Products")
        );
    }


}
