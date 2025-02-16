package org.example.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA14555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            String input = br.readLine();
            char[] ground = input.toCharArray();

            int count = 0; // 공의 개수
            for (int i = 0; i < ground.length - 1; i++) {
                if ((ground[i] == '(' && ground[i+1] == ')') || (ground[i] == '(' && ground[i+1] == '|') ||
                        (ground[i] == '|' && ground[i+1] == ')')) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}