package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class Task1 {

    private int maxNegative;
    private int minPositive;
    private int maxNegativePos;
    private int minPositivePos;

    public Task1(){
        this.minPositive = Integer.MAX_VALUE;
        this.maxNegative = Integer.MIN_VALUE;
    }

    public int[] swapIntByLoop(int @NotNull [] listInt) {

        for (int i = 0; i < listInt.length; i++) {
            if (listInt[i] > 0) {
                if (listInt[i] < this.minPositive){
                    this.minPositive = listInt[i];
                    this.minPositivePos = i;
                }
            }else if (listInt[i] < 0){
                if (listInt[i] > this.maxNegative){
                    this.maxNegative = listInt[i];
                    this.maxNegativePos = i;
                }
            }
        }

        listInt[this.minPositivePos] = this.maxNegative;
        listInt[this.maxNegativePos] = this.minPositive;
        System.out.println("Item " + this.minPositivePos + " value " + this.minPositive + " was swapped with item " +  this.maxNegativePos + " value " + this.maxNegative);

        return listInt;
    }
}
