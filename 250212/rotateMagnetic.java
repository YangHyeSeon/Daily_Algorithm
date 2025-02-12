import java.io.*;
import java.util.StringTokenizer;

class rotateMagnetic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			sb.append("#").append(t).append(" ");

			int rotation = Integer.parseInt(br.readLine());

			int[][] wheel = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 회전 횟수
			for (int i = 0; i < rotation; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int wheelNum = Integer.parseInt(st.nextToken()) - 1; // 바퀴 번호
				int direction = Integer.parseInt(st.nextToken()); // 회전 방향 (1 또는 -1)

				int[] turn = new int[4];
				turn[wheelNum] = direction; // 바퀴의 회전 방향 저장

				// 오른쪽 자석 검사
				for (int j = wheelNum + 1; j < 4; j++) {
					if (wheel[j - 1][2] == wheel[j][6]) { // 자성이 같은 경우
						break; // 회전하지 않음
					} else {
						turn[j] = -turn[j - 1]; // 자성이 다른 경우, 오른쪽 자석이 왼쪽 자석의 반대방향으로 회전
					}

				}

				// 왼족 자석 검사
				for (int j = wheelNum - 1; j >= 0; j--) {
					if (wheel[j][2] == wheel[j + 1][6]) { // 자성이 같은 경우
						break; // 회전 하지 않음
					} else {
						turn[j] = -turn[j + 1]; // 자성이 다른 경우, 왼쪽 자석이 오른쪽 자석의 반대방향으로 회전
					}
				}

				// 각 자석 회전
				for (int j = 0; j < 4; j++) {
					if (turn[j] == 0)
						continue;
					rotateWheel(wheel[j], turn[j]);
				}

			}

			// 회전이 끝난 후, 합 계산
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				if (wheel[i][0] == 1) {
					sum += (1 << i);
				}
			}

			sb.append(sum).append("\n");

		}
		System.out.println(sb);

	}

	public static void rotateWheel(int[] wheel, int direction) {
		if (direction == 1) { // 시계 방향 회전
			int last = wheel[7];
			for (int i = 7; i > 0; i--) {
				wheel[i] = wheel[i - 1];
			}
			wheel[0] = last;
		} else { // 반시계 방향 회전
			int first = wheel[0];
			for (int i = 0; i < 7; i++) {
				wheel[i] = wheel[i + 1];
			}
			wheel[7] = first;
		}
	}
}