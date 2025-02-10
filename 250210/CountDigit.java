import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDigit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int length = 0; // 만들어진 숫자의 자리수
		int digit = 1; // 자리수
		int count = 9; // 숫자의 개수 (1자리 = 9개)
		
		while (N > 0) {
			if (N >= count) {
				length += count * digit; 
				N -= count;
			} else {
				length += N * digit;
				break;
			}
			
			digit++;
			count *= 10;
		}
		
		System.out.println(length);
	}
}
