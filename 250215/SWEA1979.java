package org.example.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열의 크기
            int K = Integer.parseInt(st.nextToken()); // 단어의 길이

            //배열 생성 및 입력 받기
            int[][] puzzle = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int count = 0 ; // 단어가 들어갈 수 있는 자리의 수

            // 가로
            for (int i = 0; i < N; i++) {
                int blank = 0; // 빈 칸의 수
                for (int j = 0; j < N; j++) {
                    if (puzzle[i][j] == 1) {
                        blank++;
                    } else {
                        if (blank == K) count++; // 길이가 정확히 K일 때 카운트
                        blank = 0; // 초기화
                    }
                }
                if (blank == K) count++; // 마지막까지 연속된 경우 확인
            }

            // 세로
            for (int i = 0; i < N; i++) {
                int blank = 0; // 빈 칸의 수
                for (int j = 0; j < N; j++) {
                    if (puzzle[j][i] == 1) {
                        blank++;
                    } else {
                        if (blank == K) count++; // 길이가 정확히 K일 때 카운트
                        blank = 0; // 초기화
                    }
                }
                if (blank == K) count++; // 마지막까지 연속된 경우 확인
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");

        }
        System.out.println(sb);
    }
}
