package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ValidateUtil1 {
    private ValidateUtil1() {}

    public static void validate(Object object, Class<?> clazz) throws ValidateException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.invoke(clazz, object);
            } catch (IllegalAccessException e) {
                throw new ValidateException("Ошибка: ограниченные права доступа");
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                throw new ValidateException(cause.getMessage());
            }
        }
    }
}
