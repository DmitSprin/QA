package Components.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.lang.reflect.InvocationTargetException;

public class Component extends RemoteWebDriver {

    private static String identifier;

    private static WebElement parent;

    public static <T extends BaseComponent> WebElement getComponent(Class<T> ob, String identifier) {
        setIdentifier(identifier);
        T object = initObject(ob);
        return object.build();
    }

    public static <T extends BaseComponent> T component(Class<T> ob, String identifier) {
        setIdentifier(identifier);
        return initObject(ob);
    }

    public static <T extends BaseComponent> WebElement getComponent(Class<T> ob, String identifier, WebElement parent) {
        setParent(parent);
        setIdentifier(identifier);
        T object = initObject(ob);
        return object.build();
    }

    public static String getIdentifier() {
        return identifier;
    }

    public static <T> T initObject(Class<T> ob) {
        T object;
        try {
            object = ob.getDeclaredConstructor().newInstance();

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Incorrect component type");
        }
        return object;
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