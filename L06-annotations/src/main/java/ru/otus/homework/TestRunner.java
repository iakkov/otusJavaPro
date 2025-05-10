package ru.otus.homework;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void runTest(String className) {
        try {
            Class<?> clazz = Class.forName(className);

            List<Method> beforeMethods = new ArrayList<>();
            List<Method> testMethods = new ArrayList<>();
            List<Method> afterMethods = new ArrayList<>();

            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Before.class)) {
                    beforeMethods.add(method);
                } else if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                } else if (method.isAnnotationPresent(After.class)) {
                    afterMethods.add(method);
                }
            }

            int passed = 0;
            int failed = 0;

            for (Method testMethod : testMethods) {
                Object testInstance = clazz.getDeclaredConstructor().newInstance();
                try {
                    for (Method beforeMethod : beforeMethods) {
                        beforeMethod.invoke(testInstance);
                    }
                    testMethod.invoke(testInstance);
                    System.out.println("Тест прошел: " + testMethod.getName());
                    passed++;
                } catch (Exception e) {
                    System.out.println("тест упал: " + testMethod.getName());
                    e.printStackTrace();
                    failed++;
                } finally {
                    for (Method afterMethod : afterMethods) {
                        afterMethod.invoke(testInstance);
                    }
                }
                System.out.println("\nСтатистика:");
                System.out.println("Всего тестов: " + (passed + failed));
                System.out.println("Успешных: " + passed);
                System.out.println("Проваленных: " + failed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
