package org.example.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashMap_String {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수

        Map<String,String> siteAndPw= new HashMap<>(); // 사이트와 비밀번호를 저장할 해시맵

        // key에 사이트 주소, value에 비밀번호 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            siteAndPw.put(st.nextToken(), st.nextToken());
        }

        // M번 순회하면서 입력받은 사이트 주소를 키로 하여 해시맵에 저장된 비밀번호 가져오기
        for (int i = 0; i < M; i++) {
            sb.append(siteAndPw.get(br.readLine()));

            if (i != (M-1)) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

}


