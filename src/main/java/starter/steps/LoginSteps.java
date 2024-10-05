package starter.steps;


import net.serenitybdd.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.interacciones.MainPageInteraction;
import starter.mapeos.LoginPage;
import starter.mapeos.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    @Page
    private LoginPage loginPage;
    @Page
    private MainPage mainPage;

    @Page
    private MainPageInteraction mainPageInteraction;

    @Step("user open login page")
    public void openLoginPage() {
        loginPage.open();
        LOGGER.info("user open login page");
    }

    @Step("clear user and password fields")//clear Fields Login
    public void clearFieldsLogin() {
        loginPage.inputUsername.type(""); //sendKeys
//        loginPage.inputUsername.sendKeys("");
        loginPage.inputPassword.type("");
    }

    @Step("enter credentials")
    public void enterCredentials(String username, String password) {
        loginPage.inputUsername.type(username);
        loginPage.inputPassword.type(password);
        LOGGER.info("enter credentials with username:{} and password:{}.", username, password);
    }

    @Step("access the system")
    public void accessSystem(){
//        loginPage.btnLogin.waitUntilClickable().click();
        loginPage.getButtonByText("Sign In").waitUntilClickable().click();
    }

    @Step("validate successful login")
    public void validateSuccessfulLogin() {
        final String mensajeError = "Login was unsuccessful.";
        assertThat(mensajeError, mainPageInteraction.getTitleMainPage(), is(equalTo("Dashboard")));
        mainPageInteraction.scrollToElement(mainPage.getButtonByText("Add"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}











