package org.example;

public class Main {
    public static void main(String[] args) throws ValidateException{
        //Валидация
        Human h = new Human(150, "Настя");
        System.out.println(h);
        ValidateUtil1.validate(h, HumanTests.class);

        //Invoke
        itsWorked();
        System.out.println();

        //Default
        DefaultExample.example();
        Class<?> classValue = DefaultExample.class.getAnnotation(Default.class).value();
        System.out.println("Значение аннотации для класса: " + classValue.getName());
        Class<?> fieldValue = DefaultExample.class.getDeclaredFields()[0].getAnnotation(Default.class).value();
        System.out.println("Значение аннотации для поля: " + fieldValue.getName());
        System.out.println();

        //ToString
        ToStringExample.example();
        ToString.ToStringValue toStringClassValue = ToStringExample.class.getAnnotation(ToString.class).value();
        System.out.println("Значение аннотации для класса: " + toStringClassValue);
        ToString.ToStringValue toStringFieldValue = ToStringExample.class.getDeclaredFields()[0].getAnnotation(ToString.class).value();
        System.out.println("Значение аннотации для класса: " + toStringFieldValue);
        System.out.println();

        //Validate
        ValidateExample.example();
        Class<?>[] classArray = ValidateExample.class.getAnnotation(Validate.class).value();
        System.out.println("Значение аннотации для класса: " + resultClass(classArray));
        Class<?>[] annotationArray = CustomAnnotation.class.getAnnotation(Validate.class).value();
        System.out.println("Значение аннотации для поля: " + resultClass(annotationArray));
        System.out.println();

        //Two
        TwoExample.example();
        String str = TwoExample.class.getAnnotation(Two.class).first();
        System.out.println("Первое значение аннотации для класса: " + str);
        int num = TwoExample.class.getAnnotation(Two.class).second();
        System.out.println("Второе значение аннотации для класса: " + num);
        System.out.println();

        //Cache
        CacheExample.example();
        String[] strings = CacheExample.class.getAnnotation(Cache.class).value();
        System.out.println("Значение аннотации для класса: " + resultString(strings));
        System.out.println();

        //Валидация2
        Human h2 = new Human(150, "Петяаэ");
        System.out.println(h2.getClass());
        ValidateUtil2.validate(h2);

    }

    @Invoke
    public static void itsWorked() {
        System.out.println("Аннотация Invoke работает");;
    }

    @Default(value = DefaultExample.class)
    public class DefaultExample {
        @Default(value = String.class)
        private String defaultField;
        public static void example() {
            System.out.println("Аннотация Default работает для класса и поля");
        }
    }

    @ToString(value = ToString.ToStringValue.NO)
    public class ToStringExample {
        @ToString()
        private String defaultField;
        public static void example() {
            System.out.println("Аннотация ToString работает для класса и поля");
        }
    }

    @Validate(value = {String.class, ValidateExample.class})
    public class ValidateExample {
        public static void example() {
            System.out.println("Аннотация Validate работает для класса и аннотации");
        }
    }

    @Validate(value = {Double.class, Long.class})
    @interface CustomAnnotation {
    }

    @Two(first = "Первый", second = 2)
    public class TwoExample {
        public static void example() {
            System.out.println("Аннотация Two работает для класса");
        }
    }

    @Cache(value = {"Значение1", "Значение2", "Значение3"})
    public class CacheExample {
        public static void example() {
            System.out.println("Аннотация Cache работает для класса");
        }
    }


    public static String resultClass(Class<?>[] classArray) {
        String classes = "";
        for (Class<?> clazz : classArray) {
            classes += clazz.getName() + "  ";
        }
        return classes;
    }

    public static String resultString(String[] stringArray) {
        String strings = "";
        for (String str : stringArray) {
            strings += str + "  ";
        }
        return strings;
    }

}