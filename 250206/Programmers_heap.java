import java.util.PriorityQueue;

class Programmers_heap {
	public int solution(int[] scoville, int K) {
		int count = 0; // ���� Ƚ�� 

		// �迭�� ���� �߰�SWEA3000.java
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
			
			minHeap.add(minScoville1 + (minScoville2 * 2)); // ���ο� ���� �����
			
			count++;
			
			// �ּ����� ��Ʈ��尪�� K���� ũ�� ���� �����ϹǸ� break; (�ּ����� ��� �ڽĳ�尪���� ��Ʈ��尪���� ŭ)
			if (minHeap.peek() >= K) {
                return count;
            }
		}
		
		// ���� 1�� ���Ҵµ��� K���� ���� ��� -1 ��ȯ
        return -1;
	}
}