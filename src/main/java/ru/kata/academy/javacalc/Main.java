package ru.kata.academy.javacalc;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input: ");
            String input = scanner.nextLine();

            try {
                String result = calc(input.replace(" ", ""));
                System.out.print("Output: " + result + "\n");

            } catch (Exception e) {
                System.out.println("throws Exception");
                scanner.close();
                break;
            }
        }

    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.trim().split("\\+|-|\\*|/");

        if (tokens.length != 2) {
            throw new Exception();
        }

        int a = parseNumber(tokens[0]);
        int b = parseNumber(tokens[1]);

        if (a < 0 || a > 10 || b < 0 || b > 10) {
            throw new Exception();
        }

        char operator = input.charAt(tokens[0].length());
//        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
//            throw new Exception();
//        }

        String remainder = input.substring(tokens[0].length() + 1 + tokens[1].length()).trim();
        if (!remainder.isEmpty()) {
            throw new Exception();
        }

        int result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new Exception();
        }

        return String.valueOf(result);
    }

    private static int parseNumber(String token) throws Exception {

        if (!token.matches("\\d+")) {
            throw new Exception();
        }
        return Integer.parseInt(token);
    }
}
