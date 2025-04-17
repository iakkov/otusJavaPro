package ru.otus.homework.practica;

public class UpperCasePrinter implements Printer {
    public void print(String text) {
        System.out.println(text.toUpperCase());
    }
}
