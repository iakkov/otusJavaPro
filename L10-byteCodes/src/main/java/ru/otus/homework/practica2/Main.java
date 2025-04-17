package ru.otus.homework.practica2;

public class Main {
    public static void main(String[] args) {
        MathOperation[] array = new MathOperation[3];

        array[0] = new Adder();
        array[1] = new Subtractor();
        array[2] = new Multiplier();

        for (MathOperation mathOperation : array) {
            System.out.println(mathOperation.operate(10, 5));
        }
    }
}
