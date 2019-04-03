import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1350 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		edge[] pq=new edge[M];
		parent=new int[N+1];
		for (int i = 1; i <=N; i++) {
			parent[i]=i;
		}
		for (int i = 0; i <M; i++) {
			st=new StringTokenizer(br.readLine());
			
			pq[i]=new edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(pq, new Comparator<edge>() {

			@Override
			public int compare(edge o1, edge o2) {
				return o2.value-o1.value;
			}
		});
		int tot=0;
		for (int i = 0; i < M; i++) {
			edge Edge=pq[i];
			if(find(Edge.end)==find(Edge.start)) {
				continue;
			}
			parent[find(Edge.end)]=find(Edge.start);
			tot=tot+Edge.value;
		}
		System.out.println(tot);
		
	}
	static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		parent[n]=find(parent[n]);
		return parent[n];
	}
	static class edge{
		int start;
		int end;
		int value;
		edge(int s,int e,int v){
			start=s;
			end=e;
			value=v;
		}
	}

}