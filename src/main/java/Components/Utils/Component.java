package Components.Utils;


import Components.ComponentExceptionHandler.ComponentHandler;
import org.openqa.selenium.WebElement;


public class Component {

    private static String identifier;

    private static WebElement parent;

    public static <T extends BaseComponent> WebElement getComponent(Class<T> ob, String ident) {
        identifier = ident;
        T object = ComponentHandler.catchComponentInstanceEx(ob);
        return object.build();
    }

    public static <T extends BaseComponent> T component(Class<T> ob, String ident) {
        identifier = ident;
        T object = ComponentHandler.catchComponentInstanceEx(ob);
        return object;
    }

    public static <T extends BaseComponent> WebElement getComponent(Class<T> ob, String ident, WebElement part) {
        identifier = ident;
        parent = part;
        T object = ComponentHandler.catchComponentInstanceEx(ob);
        return object.build();
    }

    public static String getIdentifier() {
        return identifier;
    }

    public static WebElement getParent() {
        if (parent == null) {
            return null;
        }
        return parent;
    }
}