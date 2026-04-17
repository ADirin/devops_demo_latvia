package org.example;

import java.util.Scanner;

public class AveragSpeed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Averag distance");
        double distance = input.nextDouble();
        System.out.println("Averag time");
        double time = input.nextDouble();
        double averagespeed = distance / time;
        System.out.println("Averag speed: " + averagespeed);

    }

    public static double calAverageSpeed(double distance, double time){
        if (time == 0) {
            throw new IllegalArgumentException("zero is not acceptable");
        }
        return distance / time;
    }
}
