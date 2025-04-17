package ru.otus.homework.practica3;

public interface Printer {
    void print(String text);
    default void printWithPrefix(String prefix, String text) {
        print(prefix + text);
    }
}
