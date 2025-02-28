package org.example.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj 1780
public class CutPaper {
    static int[][] paper;
    static int zero;
    static int minusOne;
    static int one;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (canCut(0, 0, N)) { // 행렬의 모든 값이 같은 값을 갖는 경우
            cut(0, 0, N);
        } else { // 아닐 때 (재귀)
            for (int k = N / 3; k >= 1; k /= 3) {
                recur(0, 0, k);
            }
        }

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    public static void recur(int x, int y, int size) {
        if (x == N) {
            return;
        }

        if (y == N) {
            recur(x + size, 0, size);
            return;
        }

        if (paper[x][y] == 2) {
            recur (x, y+size,size);
            return;
        }

        if (canCut(x, y, size)) {
            cut(x, y, size);
        }

        recur(x, y + size, size);
    }

    // 자르기
    public static void cut(int x, int y, int size) {
        int value = paper[x][y];
        if (value == -1)
            minusOne++;
        else if (value == 0)
            zero++;
        else if (value == 1)
            one++;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = 2; // 잘라낸 부분 표시
            }
        }
    }

    // 잘라낼 수 있는지
    public static boolean canCut(int x, int y, int size) {
        int value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i >= N || j >= N || value != paper[i][j])
                    return false;
            }
        }

        return true;
    }

}