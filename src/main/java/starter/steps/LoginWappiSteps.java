package starter.steps;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;

import org.fluentlenium.core.annotation.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.interacciones.GeneralInteraction;
import starter.mapeos.wappi.LoginWappiPage;
import starter.mapeos.wappi.MainWappiPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginWappiSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginWappiSteps.class);
    private static final String URL_INICIO_SESION = "https://automation-wappi.vercel.app/login";

    @Page
    private LoginWappiPage loginWappiPage;

    @Page
    private MainWappiPage mainWappiPage;

    @Page
    private GeneralInteraction generalInteraction;

    @Step("user open login page")
    public void openLoginPage() {
        generalInteraction.openPage(URL_INICIO_SESION);
        LOGGER.info("user open login page");
    }

    @Step("enter credentials")
    public void enterCredentials(String username, String password) {
        Serenity.setSessionVariable("username").to(username);
        Serenity.setSessionVariable("password").to(password);
        loginWappiPage.inputUsername.type(username);
        loginWappiPage.inputPassword.type(password);
        LOGGER.info("enter credentials with username:{} and password:{}.", username, password);
    }

    @Step("access the system")
    public void accessSystem(){
        loginWappiPage.btnLogin.waitUntilClickable().click();
    }

    @Step("validate successful login")
    public void validateSuccessfulLogin() {
        final String mensajeError = "Login was unsuccessful.";
        String username = Serenity.sessionVariableCalled("username");
        String password = Serenity.sessionVariableCalled("password");
        assertThat(mensajeError, mainWappiPage.txtTitleMainPage.waitUntilVisible().getText(), is(equalTo("Ofertas")));
        LOGGER.info("Sesión con usuario '{}' y contraseña '{}'", username, password);
    }

}











