import java.io.*;
import java.util.*;

public class Solution {
	static int[] gyu;
	static int[] in;
	static int[] numbers;
	static boolean[] isSelected;
	static int win, lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			gyu = new int[9];
			in = new int[9];
			numbers = new int[9];
			isSelected = new boolean[9];
			win = 0;
			lose = 0;

			boolean[] cards = new boolean[19];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				cards[gyu[i]] = true;
			}

			int idx = 0;

			for (int i = 1; i <= 18; i++) {
				if (!cards[i]) {
					in[idx++] = i;
				}
			}

			bt(0);

			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	static void bt(int cnt) {
		if (cnt == 9) {
			int gyuScore = 0;
			int inScore = 0;

			for (int i = 0; i < 9; i++) {
				if (gyu[i] > numbers[i]) {
					gyuScore += gyu[i] + numbers[i];
				} else {
					inScore += gyu[i] + numbers[i];
				}
			}

			if (gyuScore > inScore) {
				win++;
			} else if (gyuScore < inScore) {
				lose++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = in[i];
			isSelected[i] = true;
			bt(cnt + 1);
			isSelected[i] = false;
		}
	}
}