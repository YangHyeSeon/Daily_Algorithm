import java.util.ArrayList;

class HanoiTop1 {
	static ArrayList<int[]> list = new ArrayList<>();
	public int[][] solution(int n) {
		int count = (int) Math.pow(2, n) - 1;
        int[][] answer = new int[count][2];
        
        hanoi(n, 1, 2, 3);
        
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
	
	public static void hanoi(int n, int start, int sub, int end) {
		if (n == 1) {
			int[] result = {start, end};
			list.add(result);
			return;
		}
		
		// B(2번째 기둥)으로 옮기기(n을 제외하고)
		hanoi(n-1, start, end, sub);
		
		// n을 C(마지막 기둥)으로 옮기기
		int[] toC = {start, end};
		list.add(toC);
		
		// C(세번째 기둥)로 옮기기 (n-1을 제외하고)
		hanoi(n-1, sub, start, end);
	}
}
