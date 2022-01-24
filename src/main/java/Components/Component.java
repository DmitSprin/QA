package Components;


import Components.Buttons.BuyButton;
import Components.TopSearch.TopSearch;
import org.openqa.selenium.WebElement;


public class Component {

    private static Object T;
    private static String identifier;

    public static <T extends IComponent> WebElement getComponent(Class<T> ob, String ident) {

        identifier = ident;
        if (ob == BuyButton.class) {
            return new BuyButton().build();
        } else if (ob == TopSearch.class) {
            return new TopSearch().build();
        }

        return (WebElement) new RuntimeException();
    }

    public static <T extends IComponent> T component(Class<T> ob, String ident) {

        identifier = ident;
        if (ob == BuyButton.class) {
            return (T) new BuyButton();
        } else if (ob == TopSearch.class) {
            return (T) new TopSearch().build();
        }

        return (T) new RuntimeException();
    }


    public static String getIdentifier() {
        return identifier;
    }


}