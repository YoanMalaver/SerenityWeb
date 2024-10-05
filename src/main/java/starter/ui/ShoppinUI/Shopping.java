package starter.ui.ShoppinUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Shopping {

    public static final Target RESULTS =  Target.the("Count results")
            .located(By.cssSelector("span.heading-counter"));
}
