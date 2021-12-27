package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int[] listInt = new int [10];
        System.out.println("Creating a list of int ...");
        for (int i = 0; i < listInt.length; i++){
            listInt[i] = ThreadLocalRandom.current().nextInt(-100, 100);
            System.out.print(listInt[i] + ", ");
        }
        System.out.println();

//       Задача1. В массиве целых чисел поменять местами максимальный отрицательный элемент и минимальный положительный.
        System.out.println("Task1. Swapping max negative and min positive ints by for loop ...");
        Task1 swapper = new Task1();
        listInt = swapper.swapIntByLoop(listInt);

        for (int i = 0; i < listInt.length; i++){
            System.out.print(listInt[i] + ", ");
        }
        System.out.println();

//       Задача2. В массиве целых чисел определить сумму элементов, состоящих на чётных позициях.
        System.out.println("Task2. Determining the sum of the elements of even positions  ...");
        int sumOfEven = 0;
        for (int i = 0; i < listInt.length; i+=2){
            sumOfEven += listInt[i];
        }
        System.out.println("The sum of even items = " + sumOfEven);

//       Задача3. В массиве целых чисел заменить нулями отрицательные элементы.
        System.out.println("Task3. Setting all the negative items in zero  ...");

        Iterator iterator = Arrays.stream(listInt).iterator();
        int val;
        while(iterator.hasNext()){
            val = (int)iterator.next();
            if (val < 0){
                System.out.print("0, ");
            }else{
                System.out.print(val + ", ");
            }
        }
        System.out.println();

//       Задача4. В массиве целых чисел утроить каждый положительный элемент, который стоит перед отрицательным.
        System.out.println("Task4. Multiply all the positive items if the next is negative  ...");
        for (int i = 0; i < listInt.length - 1; i++){
            if (listInt[i] > 0 && listInt[i + 1] < 0){
                System.out.println("Item " + i + " value " + listInt[i] + " will be multiply by three " + listInt[i] * 3);
            }else{
                System.out.println(listInt[i]);
            }
        }

//        Задача5. В массиве целых чисел найти разницу между средним арифметическим и значение минимального элемента.
        System.out.println("Task5. Finding the difference between the average value and the value of the minimum element   ...");
        int average = sumOfEven/listInt.length;
        System.out.println("The average value is " + average);

        OptionalDouble averageDouble = Arrays.stream(listInt).average();
        System.out.println("The averageDouble value by stream is " + averageDouble);

        int minInt = Integer.MAX_VALUE;
        for (int i = 0; i < listInt.length - 1; i++){
            if (listInt[i] < minInt){
                minInt = listInt[i];
            }
        }
        System.out.println("The min item is " + minInt);
        OptionalInt minOptionalInt = Arrays.stream(listInt).min();
        System.out.println("The min item by stream is " + minOptionalInt);
        System.out.println("The difference " + average + " - " + minInt + " = " + (average - minInt));

//       Задача6. В массиве целых чисел вывести все элементы, которые встречаются больше одного раза и индексы которых нечётные.

//        Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), выполняет арифметическую операцию
//        («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. Для каждой операции использовать отдельный метод.
        System.out.println("Task calculator  ...");
        Calculator calculator = new Calculator();
        calculator.calculate();
    }
}
