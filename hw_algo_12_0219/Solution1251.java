package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution1251 {
	static int N,E;//정점수, 간선수
	static int[] parent;
	static boolean[] visit;
	static double mst;
	static PriorityQueue<Edge> pq;
	static double En;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <=T; i++) {
			N=Integer.parseInt(br.readLine().trim());
			//각각 섬과의 거리 계산
			double[][] map=new double[N][2];
			StringTokenizer st;
			st=new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < map.length; j++) {
				map[j][0]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[j][1]=Integer.parseInt(st.nextToken());				
			}
			visit = new boolean[N];
			parent=new int[N];
			pq=new PriorityQueue<>(new EdgeComparator());
			int count=0;
			for (int j = 0; j < map.length-1; j++) {
				for (int j2 = j+1; j2 < map.length; j2++) {
					int start=j;
					int end=j2;
					double value=Math.sqrt(Math.pow(map[j][0]-map[j2][0], 2)+Math.pow(map[j][1]-map[j2][1], 2));
					//System.out.println(value);
					pq.add(new Edge(start,end,value));
					count++;
				}
			}
			En=Double.parseDouble(br.readLine().trim());
			//mst
			mst=0;
			E=count;
			kruskal();
			System.out.printf("#%d %.0f\n",i,mst);
			//System.out.println("#"+i+" "+mst);
		}
		
	}
	static void kruskal() {
		for (int i = 0; i <N; i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<E;i++) {
			Edge edge=pq.poll();


			if(find(edge.start)==find(edge.end)) {
				continue;
			}
			union(edge.start,edge.end);
			mst=mst+edge.value*edge.value*En;
			//System.out.println(edge.start+" "+edge.end+" "+edge.value);
		}
		
		
	}
	static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		parent[n]=find(parent[n]);
		return parent[n];
	}
	static void union(int n1,int n2) {
		int p1=find(n1);
		int p2=find(n2);
		if(p1!=p2) {
			parent[p1]=p2;
		}
	}
	
	static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1 : -1;
		}

	}

	static class Edge {
		int start, end;
		double value;
		Edge(int s, int e, double v) {
			start = s;
			end = e;
			value = v;
		}

	}
}
/*
1
2
0 0
0 100
1.0

1
4
0 0 400 400
0 100 0 100
1.0

*/
