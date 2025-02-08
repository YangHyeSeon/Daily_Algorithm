package org.example.programmers;

class countDivisor {
    public int solution(int left, int right) {
        int sum = 0;

        // 제곱수를 제외한 모든 수의 약수의 개수는 짝수개
        // n의 약수의 개수를 구하는 경우 루트n까지의 수로 나누어 나머지가 0이 된 수의 개수에 *2하기 때문!
        // 다만 n이 제곱수인 경우에는 위 개수에서 -1하기 때문에 약수의 개수가 홀수로 나올 수 밖에 없음
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }
}
