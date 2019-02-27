import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1828_2 {

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st;
		int[][] aaa = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s > e) {
				int tmp;
				tmp = s;
				s = e;
				e = s;
			}
			aaa[i][0] = s;
			aaa[i][1] = e;
		}
		Arrays.sort(aaa, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1]-o2[1];
				} 
				else {
					return o1[0] - o2[0];
				}
			}
		});
		for (int i = 0; i < aaa.length; i++) {
			System.out.print(aaa[i][0]+" "+aaa[i][1]);				
		System.out.println();
	}
		int count = 1;
		for (int i = 0; i < aaa.length; i++) {
			for (int j = i + 1; j < aaa.length; j++) {
				if (aaa[i][0] <= aaa[j][0] && aaa[i][1] >= aaa[j][0]) {
					aaa[i][0]=aaa[j][0];
					if(aaa[j][1]<aaa[i][1]) {
						aaa[i][1]=aaa[j][1];
					}
				} else {
					i = j - 1;
					count++;
					break;
				}
			}
		}
//		for (int i = 0; i < aaa.length; i++) {
//				System.out.print(aaa[i][0]+" "+aaa[i][1]);				
//			System.out.println();
//		}

		// 시작은도 끝온도 표시
		System.out.println(count);
	}

}