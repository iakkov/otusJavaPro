package ru.otus.homework.practica3;

import java.io.PrintStream;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Printer newPrinter = new ConsolePrinter();
        newPrinter.printWithPrefix("Dr.", " Iakov");
    }
}
