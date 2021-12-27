package com.company;

import java.util.Scanner;

public class Calculator {

    private double addition(double first, double second){
        return first + second;
    }

    private double subtraction(double first, double second){
        return first - second;
    }

    private double multiplication(double first, double second){
        return first * second;
    }

    private double division(double first, double second){
        return first / second;
    }

    public void calculate(){
        double first;
        double second;
        String action;

        System.out.println("Hello! I can calculate numbers.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's start! Enter the number:");
        first = scanner.nextDouble();
        System.out.println("Enter the action:");
        action = scanner.next();
        System.out.println("Enter the second number:");
        second = scanner.nextDouble();

        switch (action.charAt(0)){
            case ('+'):
                System.out.println(first + " + " + second + " = " + this.addition(first, second));
                break;
            case ('-'):
                System.out.println(first + " - " + second + " = " + this.subtraction(first, second));
                break;
            case ('*'):
                System.out.println(first + " * " + second + " = " + this.multiplication(first, second));
                break;
            case ('/'):
                System.out.println(first + " / " + second + " = " + this.division(first, second));
                break;
            default:
                System.out.println("The action is not defined.");
        }
    }
}
