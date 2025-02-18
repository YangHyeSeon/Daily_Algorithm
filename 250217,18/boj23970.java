package org.example.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기

        String[] input = br.readLine().split(" ");
        int[] arrA = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        input = br.readLine().split(" ");
        int[] arrB= Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        if (Arrays.equals(arrA, arrB)) {
            System.out.println(1);
            return;
        }

        for (int i = N-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                // 배열A 버블정렬
                if (arrA[j] > arrA[j+1]) {
                    int swap = arrA[j];
                    arrA[j] = arrA[j+1];
                    arrA[j+1] = swap;

                    // 교환한 후 배열A가 배열B와 일치하는지 판단
                    if (arrA[j] == arrB[j] && arrA[j+1] == arrB[j+1] && Arrays.equals(arrA, arrB)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}