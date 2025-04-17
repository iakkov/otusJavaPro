package ru.otus.homework.practica;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Printer consolePrinter = new ConsolePrinter();
        Printer upperCasePrinter = new UpperCasePrinter();

        consolePrinter.print("Привет, мир!");
        upperCasePrinter.print("Привет, мир!");
    }
}
