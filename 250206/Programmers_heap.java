import java.util.PriorityQueue;

class Programmers_heap {
	public int solution(int[] scoville, int K) {
		int count = 0; // 섞은 횟수 

		// 배열을 힙에 추가SWEA3000.java
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
        for (int num : scoville) {
            minHeap.add(num);
        }

        if (minHeap.peek() >= K) {
            return 0;
        }
        
		while (minHeap.size() > 1) {
			int minScoville1 = minHeap.poll();
			int minScoville2 = minHeap.poll();
			
			minHeap.add(minScoville1 + (minScoville2 * 2)); // 새로운 음식 만들기
			
			count++;
			
			// 최소힙의 루트노드값이 K보다 크면 조건 만족하므르 break; (최소힙의 모든 자식노드값들은 루트노드값보다 큼)
			if (minHeap.peek() >= K) {
                return count;
            }
		}
		
		// 힙에 1개 남았는데도 K보다 작은 경우 -1 반환
        return -1;
	}
}