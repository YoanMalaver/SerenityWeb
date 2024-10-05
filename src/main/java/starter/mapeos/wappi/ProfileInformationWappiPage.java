package starter.mapeos.wappi;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.annotations.At;
import starter.mapeos.GeneralPage;

@At("https://automation-wappi.vercel.app/profile")
public class ProfileInformationWappiPage extends GeneralPage {

    @FindBy(id = "image")
    public WebElementFacade inputImage;

    @FindBy(id = "name")
    public WebElementFacade txtName;

    @FindBy(id = "lastName")
    public WebElementFacade txtLastName;

    @FindBy(id = "bornDate")
    public WebElementFacade txtBornDate;

    @FindBy(id = "country")
    public WebElementFacade countryDropdown;

    @FindBy(id = "save-profile")
    public WebElementFacade btnSaveInformationProfile;

    @FindBy(xpath = "//div[@id='confirmation-modal']//p")
    public WebElementFacade txtUpdateResult;

    public WebElement getElementGender(String gender) {
        return getDriver().findElement(By.id(gender));
    }

}
