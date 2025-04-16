package main.java.ru.otus.homework;

public class Demo {
    public static void main(String[] args) {
        TestLoggingInterface originalObject = new TestLogging();
        TestLoggingInterface proxyObject = MyProxy.createProxy(originalObject);

        proxyObject.calculation(4, 5);
    }
}
