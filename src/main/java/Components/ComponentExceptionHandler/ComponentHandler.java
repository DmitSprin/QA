package Components.ComponentExceptionHandler;

import java.lang.reflect.InvocationTargetException;

public class ComponentHandler {

    public static <T> T catchComponentInstanceEx(Class<T> ob){
        T object;
        try {
            object = ob.getDeclaredConstructor().newInstance();

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Incorrect component type");
        }
        return object;


    }
}
