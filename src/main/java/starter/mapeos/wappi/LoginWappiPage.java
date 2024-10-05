package starter.mapeos.wappi;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import starter.mapeos.GeneralPage;

public class LoginWappiPage extends GeneralPage {

    @FindBy(how = How.ID, using = "username")
    public WebElementFacade inputUsername;

    @FindBy(how = How.ID, using = "password")
    public WebElementFacade inputPassword;

    @FindBy(id = "button-login")
    public WebElementFacade btnLogin;

}
