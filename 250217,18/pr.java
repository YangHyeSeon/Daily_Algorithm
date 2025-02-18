package org.example.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class releaseQueue {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> release = new ArrayList<>();

        int duration = 0; // 작업을 완료하는데 걸리는 시간
        Queue<Integer> days = new LinkedList<>(); // 각 작업 소요 시간의 값을 저장
        for (int i = 0; i < progresses.length; i++) {
            if ((100-progresses[i])%speeds[i] == 0) {
                duration = (100-progresses[i])/speeds[i];
                days.add(duration);
            } else {
                duration = (100-progresses[i])/speeds[i] + 1;
                days.add(duration);
            }
        }

        int firstTask = days.poll(); // 첫번째 작업의 소요 시간
        int count = 1; // 배포 가능한 기능의 개수
        while (!days.isEmpty()) {
            if (days.peek() <= firstTask) { // 첫번째 작업과 함께 배포 가능한지
                days.poll();
                count++;
            } else {
                release.add(count);
                firstTask = days.poll(); // 첫번째 작업의 소요 시간 값 갱신
                count = 1; // count 값 초기화
            }
        }

        release.add(count); // 마지막 count 추가

        int[] answer = release.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}