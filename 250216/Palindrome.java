package org.example.programmers;

class Palindrome {
    public int solution(String s) {
        char[] stringArray = s.toCharArray();

        int max = 1; // 가장 긴 펠린드롬의 길이

        for (int len = stringArray.length; len >= 1; len--) { // len : 펠린드롬의 길이
            for (int indx = 0; indx <= stringArray.length - len; indx++) { // indx : 펠린드롬인지 판단하기 위해 탐색할 indx
                boolean palindrome = true;

                int start = indx; // 펠린드롬의 첫번째 인덱스
                int end = start + len - 1; // 펠린드롬의 마지막 인덱스

                // 특정 길이의 문자열이 펠린드롬인지 확인
                while (start < end) { // 첫번째 인덱스와 마지막 인덱스가 교차할 때까지 반복
                    if (stringArray[start] != stringArray[end]) { // 다르면 펠린드롬이 아니므로 다음으로 넘어감
                        palindrome = false;
                        break;
                    }

                    start++;
                    end--;
                }

                if (palindrome) {
                    max = len;
                    return max;
                }
            }
        }

        return max;
    }
}