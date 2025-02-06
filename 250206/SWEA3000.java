import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SWEA3000 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 경근이가 몇번 숫자를 적는지
			int A = Integer.parseInt(st.nextToken()); // 경근이가 처음 공책에 쓴 자연수

			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 (최소 힙 크기 + 1)
			PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙

			maxHeap.add(A);

			long sum = 0; // 중간값의 합
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				maxHeap.add(Integer.parseInt(st.nextToken()));
				minHeap.add(Integer.parseInt(st.nextToken()));

				// 중간값을 구하려면 최대 힙의 루트노드 값이 최소 힙의 루트노드 값보다 작아야 함
				// maxHeap의 루트노드값이 minHeap의 루트노드값보다 크면 두 값을 바꿔줌(Swap)
				// 바꿔주고 나면 중간값 == maxHeap의 루트노드값
				if (maxHeap.peek() > minHeap.peek()) {
					int max = maxHeap.poll();
					int min = minHeap.poll();

					maxHeap.add(min);
					minHeap.add(max);
				}
				sum += maxHeap.peek();
			}

			sb.append(sum%20171109).append("\n");
		}

		System.out.println(sb);
	}

}
