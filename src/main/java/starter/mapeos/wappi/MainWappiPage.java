package starter.mapeos.wappi;


import net.serenitybdd.annotations.At;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import starter.mapeos.GeneralPage;

@At("https://automation-wappi.vercel.app/home")
public class MainWappiPage extends GeneralPage {

    @FindBy(xpath = "//h1")
    public WebElementFacade txtTitleMainPage;

    @FindBy(xpath = "//a[contains(text(), 'Información personal')]")
    public WebElementFacade menuOptionUpdateProfile;

}
