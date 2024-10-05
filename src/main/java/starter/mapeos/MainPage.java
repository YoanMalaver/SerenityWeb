package starter.mapeos;

import net.serenitybdd.annotations.At;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@At("https://demo.serenity.is/")
public class MainPage extends GeneralPage {

    @FindBy(xpath = "//main//h1")
    public WebElementFacade txtTitleMainPage;

}
