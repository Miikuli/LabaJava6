package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ValidateUtil2 {
    private ValidateUtil2() {}

    public static void validate(Object object) throws ValidateException {
        Class<?>[] classes = object.getClass().getAnnotation(Validate.class).value();
        for (Class<?> clazz : classes) {
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
}
