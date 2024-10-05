package starter.questions;

import net.serenitybdd.screenplay.Question;

import static starter.ui.ShoppinUI.Shopping.RESULTS;

public class ShoppingQuestions {

    public static Question<Integer> numbersOfResults() {
        return actor -> {
            String textValue = RESULTS.resolveFor(actor).getTextValue().trim().replaceAll("[^0-9]", "");
            return Integer.parseInt(textValue);
        };
    }
    public static Question<String> numbersOfResultsText() {
        return actor -> {
            String text = RESULTS.resolveFor(actor).getText().trim();
            return text.replaceAll("[^0-9]", "");
        };
    }

}
