package org.example;

public class HumanTests {
    public static void test5(Human human) throws Exception {
        if (human.getAge() < 1 || human.getAge() > 200) {
            throw new Exception("ошибка в test5: возраст человека не в диапазоне от 1 до 200");
        }
    }

    public static void test4(Human human) throws Exception {
        if (human.getName().length() > 5) {
            throw new Exception("ошибка в test4: имя человека состоит больше, чем из 5 букв");
        }
    }
}