package org.example.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj 6198
public class Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 빌딩의 개수

        java.util.Stack<Integer> buildings = new java.util.Stack<>();

        long count = 0; // 관리인들이 옥상정원 확인 할 수 있는 빌딩 수
        for (int i = 0; i < N; i++) {
            int b = Integer.parseInt(br.readLine());

            while (!buildings.isEmpty() && buildings.peek() <= b) {
                buildings.pop();
            }

            count += buildings.size();
            buildings.add(b);
        }

        System.out.println(count);
    }
}