package org.example.programmers;

import java.util.StringTokenizer;

public class MaxMin {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");

        // 첫 번째 값을 가져와 초기화
        int first = Integer.parseInt(st.nextToken());
        int max = first;
        int min = first;

        // 나머지 값들과 비교하여 업데이트
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return min + " " + max;
    }
}
