package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class N3 {
    public static void main(String[] args) {
        String filename = "17-342.txt";
        int min_37 = 10001;
        int max_73 = 0;
        List<Integer> sequence = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                sequence.add(number);
                if (number % 37 == 0 && number < min_37) {
                    min_37 = number;
                }
                if (number % 73 == 0 && number > max_73) {
                    max_73 = number;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        int count = 0;
        int minSum = 10000 + 10000;
        for (int i = 0; i < sequence.size() - 1; i++) {
            int a = sequence.get(i);
            int b = sequence.get(i + 1);
            if ((a > min_37 && a < max_73 && b <= min_37) || (a >= max_73 && b < max_73 && b > min_37)) {
                count++;
                int sum = a + b;
                if (sum < minSum) {
                    minSum = sum;
                }
            }
        }
        System.out.println("Кол-во найденных пар: " + count);
        System.out.println("Мин. сумма элементов среди этих пар: " + minSum);
    }
}