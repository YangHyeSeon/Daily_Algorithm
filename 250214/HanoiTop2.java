import java.io.*;
import java.math.BigInteger;

public class HanoiTop2 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger count = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);

		sb.append(count);
		
		if (N <= 20) {
			sb.append("\n");
			hanoi(N, 1, 2, 3);	
		}
		
		System.out.println(sb);
	}

	public static void hanoi(int n, int start, int sub, int end) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}

		// B(2번째 기둥)으로 옮기기(n을 제외하고)
		hanoi(n - 1, start, end, sub);

		// n을 C(마지막 기둥)으로 옮기기
		sb.append(start).append(" ").append(end).append("\n");
		
		// C(세번째 기둥)로 옮기기 (n-1을 제외하고)
		hanoi(n - 1, sub, start, end);
	}

}
