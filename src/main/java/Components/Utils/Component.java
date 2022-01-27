package Components.Utils;


import Components.ComponentExceptionHandler.ComponentHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Component extends RemoteWebDriver {

    private static String identifier;

    private static WebElement parent;

    public static <T extends BaseComponent> WebElement getComponent(Class<T> ob, String ident) {
        setIdentifier(ident);
        T object = ComponentHandler.catchComponentInstanceEx(ob);
        return object.build();
    }

    public static <T extends BaseComponent> T component(Class<T> ob, String ident) {
        setIdentifier(ident);
        return ComponentHandler.catchComponentInstanceEx(ob);
    }

    public static <T extends BaseComponent> WebElement getComponent(Class<T> ob, String ident, WebElement part) {
        setParent(part);
        setIdentifier(ident);
        T object = ComponentHandler.catchComponentInstanceEx(ob);
        return object.build();
    }

    public static String getIdentifier() {
        return identifier;
    }

    public static WebElement getParent() {
        return parent;
    }

    public static void setIdentifier(String ident) {
        identifier = ident;
    }

    public static void setParent(WebElement parnt) {
        parent = parnt;
    }
}