package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //Создаем объект Human с корректными данными (возраст 150, имя "Петя")
    //Проверяем, что метод validate не вызывает исключений при проверке этого объекта
    //Этот тест проверяет, что валидация проходит успешно для корректных данных
    @Test
    public void testValidateWithValidData() {
        Human validHuman = new Human(150, "Петя");
        assertDoesNotThrow(() -> ValidateUtil2.validate(validHuman));
    }

    //Создаем объект Human с некорректным возрастом (750)
    //Проверяем, что метод validate вызывает корректное исключение ValidateException ("ошибка в test5: возраст человека не в диапазоне от 1 до 200")
    //Этот тест проверяет, что валидация правильно обрабатывает некорректный возраст
    @Test
    public void testValidateWithInvalidAge() {
        Human invalidAgeHuman = new Human(750, "Настя");
        ValidateException exception = assertThrows(ValidateException.class, () -> ValidateUtil2.validate(invalidAgeHuman));
        assertEquals("ошибка в test5: возраст человека не в диапазоне от 1 до 200", exception.getMessage());
    }

    //Создаем объект Human с некорректным именем ("С новым годом!", которое состоит из более чем 5 букв)
    //Проверяем, что метод validate вызывает корректное исключение ValidateException ("ошибка в test4: имя человека состоит больше, чем из 5 букв")
    //Этот тест проверяет, что валидация правильно обрабатывает некорректное имя
    @Test
    public void testValidateWithInvalidName() {
        Human invalidNameHuman = new Human(5, "С новым годом!");
        ValidateException exception = assertThrows(ValidateException.class, () -> ValidateUtil2.validate(invalidNameHuman));
        assertEquals("ошибка в test4: имя человека состоит больше, чем из 5 букв", exception.getMessage());
    }

    //Создаем объект Human с несколькими ошибками (некорректный возраст и имя)
    //Проверяем, что метод validate вызывает исключение ValidateException
    //Проверяем, что сообщение исключения содержит одно из ожидаемых сообщений об ошибках
    //Этот тест проверяет, что валидация правильно обрабатывает объекты с несколькими ошибками
    @Test
    public void testValidateWithMultipleErrors() {
        Human invalidHuman = new Human(750, "С новым годом!");
        ValidateException exception = assertThrows(ValidateException.class, () -> ValidateUtil2.validate(invalidHuman));
        assertTrue(exception.getMessage().contains("ошибка в test5: возраст человека не в диапазоне от 1 до 200") ||
                exception.getMessage().contains("ошибка в test4: имя человека состоит больше, чем из 5 букв"));
    }
}