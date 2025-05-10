package ru.otus.homework;

public class TestClass {
    @Before
    public void setup() {
        System.out.println("запуск");
    }

    @Test
    public void test1() {
        System.out.println("работа первого теста");
    }

    @Test
    public void test2() {
        System.out.println("работа второго теста");
        throw new RuntimeException("ошибка");
    }

    @After
    public void finish() {
        System.out.println("после теста");
    }
}
