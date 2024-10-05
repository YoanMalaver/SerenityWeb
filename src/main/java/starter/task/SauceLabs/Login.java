package starter.task.SauceLabs;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import starter.models.Users;

public class Login {

    public static Performable asA(Users user) {
        return Task.where(
                "{0} log in as a " + user,
                Enter.theValue(user.username).into("#user-name"),
                Enter.theValue(user.password).into("#password"),
                Click.on(Button.withNameOrId("Login"))
        );
    }
}
