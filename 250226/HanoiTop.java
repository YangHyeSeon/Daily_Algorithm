package org.example.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTop {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, N) - 1).append("\n"); // 하노이탑 이동 횟수

        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi (int n, int start, int sub, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        // n을 제외하고 sub(2번째 기둥)으로 모두 옮기기
        hanoi(n-1, start, end, sub);

        // n을 end(마지막 기둥)으로 옮기기
        sb.append(start).append(" ").append(end).append("\n");

        // n-1을 제외하고 모두 end(마지막 기둥)으로 옮기기
        hanoi(n-1, sub, start, end);
    }
}