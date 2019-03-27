package D3;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] people = new int[N];
			TreeSet<Integer> ts = new TreeSet<>();
			for (int j = 0; j < people.length; j++) {
				ts.add(sc.nextInt());
			}
			int now = 0;
			int fish = 0;
			boolean result=true;
			while (!ts.isEmpty()) {
				int p = ts.pollFirst();
				if (p - now >= M) {
					fish = fish + (p - now) / M * K;
					fish--;
					now = now + (p - now) / M * M;
				} else {
					fish--;
				}
				if(fish<0) {
					result=false;
					break;
				}
			}
			if(result) {
				System.out.println("#"+i+" Possible");
			}else {
				System.out.println("#"+i+" Impossible");	
			}
		}
	}

}