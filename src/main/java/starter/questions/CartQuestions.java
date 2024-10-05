package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;
import java.util.List;

public class CartQuestions {

    //Questions Lamdba

    public static Question<Integer> CurrenlyDisplayed() {
        return Text.of(".shopping_cart_badge").asInteger();
    }
    public static Question<Collection<String>> CurrenlyCartContents() {
        return Text.ofEach(".inventory_item_name");
    }

}
