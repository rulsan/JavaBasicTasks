package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        int[] listInt = new int [10];
        for (int i = 0; i < listInt.length; i++){
            listInt[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }

        for (int i = 0; i < listInt.length; i++){
            System.out.println(listInt[i]);
        }

        System.out.println("Swapping int by for loop ...");
        Task1 swapper = new Task1();
        listInt = swapper.swapIntByLoop(listInt);

        for (int i = 0; i < listInt.length; i++){
            System.out.println(listInt[i]);
        }
    }
}
