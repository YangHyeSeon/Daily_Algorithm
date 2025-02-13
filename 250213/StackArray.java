import java.io.*;
import java.util.*;

public class StackArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int start = 0; // 어디까지 stack에 넣었는지 표시
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine()); // 입력받은 수
			
			if (input > start) { // 입력받은 수가 마지막으로 stack에 넣은 수보다 작은 경우
				for (int j = start+1; j <= input; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				start = input; // start 갱신
			} else if (input != stack.peek()) { // stack 맨 위의 수가 입력받은 수와 같지 않은 경우
				System.out.println("NO"); // 수열 만들 수 없음 (pop한 숫자와 다르므로)
				return;
			}
			
			// 입력 받은 수(=수열에 있는 수)는 pop 되었다는 뜻이므로 어쨋든 pop
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
	}

}
