package ru.project.study;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciNaive(1));
    }

    private static long fibonacciNaive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }
}
