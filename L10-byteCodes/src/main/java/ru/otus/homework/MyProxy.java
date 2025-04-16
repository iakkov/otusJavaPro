package main.java.ru.otus.homework;


import java.lang.reflect.*;

public class MyProxy {
    public static TestLoggingInterface createProxy(TestLoggingInterface target) {
        return (TestLoggingInterface) Proxy.newProxyInstance(
                MyProxy.class.getClassLoader(),
                new Class[]{TestLoggingInterface.class},
                (proxy, method, args) -> {
                    Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

                    if (realMethod.isAnnotationPresent(Log.class)) {
                        System.out.print("executed method: " + method.getName());
                        if (args != null) {
                            for (int i = 0; i < args.length; i++) {
                                System.out.print(", param" + (i + 1) + ": " + args[i]);
                            }
                        }
                        System.out.println();
                    }

                    return method.invoke(target, args);
                }
        );
    }
}