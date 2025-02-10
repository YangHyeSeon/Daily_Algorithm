class BinarySearch {
    public int solution(int[] stones, int k) {
        int r = -1; // 0이 되도록 하는 최대 연산 횟수
        int l = 0; // 0이 되도록 하는 최소 연산 횟수
        
        // 최대 연산 횟수 == 디딤돌 배열의 값들 중 가장 큰 값
        for (int num : stones) {
        	r = Math.max(num, r);
        }
        
        while (l <= r) {
        	int m = (l+r) / 2; // 연산 횟수의 중간값
        	
        	int sequence = 0; // 연속하여 0이 된 디딤돌의 개수
        	int maxSequence = 0; // 연속하여 0이 된 디딤돌의 개수의 최대값 저장
        	
        	for (int i = 0; i < stones.length; i++) {
        		// 디딤돌에 적힌 숫자가 m 이하면 m번 연산했을 때는 이미 0이 되어있을 것
        		if (stones[i] <= m) {
        			sequence++; // 따라서 sequence++
        			maxSequence = Math.max(sequence, maxSequence); // 연속하여 0이 된 가장 긴 경우의 수 저장
        		} else {
        			sequence = 0; // 연속한 0이 끊어졌으므로 sequence 초기화
        		}
        	}
        	
        	// (연속하여 0이 된 가장 긴 경우+1)이 한번에 건너뛸 수 있는 디딤돌의 최대 칸 수보다 큰 경우
        	if (maxSequence + 1 > k) {
        		r = m - 1; // 최대 연산 횟수의 값 조정 (중간값이 작아짐)
        	} else { // 그렇지 않은 경우, 
        		l = m + 1; // 최소 연산 횟수의 값 조정 (중간값이 커짐)
        	}
        }
        
        return l; // 최소 연산 횟수
    }
}
