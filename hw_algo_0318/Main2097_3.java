package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2097_3 {
	static int M,N;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine().trim());
		N=Integer.parseInt(st.nextToken());//정점
		M=Integer.parseInt(st.nextToken());
		//1번이 출발점
		int[][] map=new int[N+1][N+1];
		int[] path=new int[N+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine().trim());
			for (int j = 1; j < N+1; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visit=new boolean[N+1];
		int[] distance=new int[N+1];
			for (int i = 1; i < distance.length; i++) {
				distance[i]=Integer.MAX_VALUE;
			}
			distance[1]=0;
			visit[1]=true;
			for (int i = 1; i < distance.length; i++) {
				if(map[1][i]!=0) {
					distance[i]=map[1][i];
				}
			}
			while(true) {
				if(Allvisited()) {
					break;
				}
				int min=Integer.MAX_VALUE;
				int minNode=-1;
				for (int i = 1; i < distance.length; i++) {
					if(!visit[i]&&distance[i]<min) {
						min=distance[i];
						minNode=i;
					}
				}
				//path[minNode]=minNode;
				visit[minNode]=true;
				for (int i = 1; i < distance.length; i++) {
					if(!visit[i]&&map[minNode][i]!=0&&distance[i]>distance[minNode]+map[minNode][i]) {
						distance[i]=distance[minNode]+map[minNode][i];
						path[i]=minNode;
					}
				}
				
			}
			ArrayList<Integer> arr=new ArrayList<>();
			int now=M;
			
			while(true) {
				arr.add(now);
				now=path[now];
				if(path[now]==0) {
					arr.add(now);
					break;
				}
				
			}
			System.out.println(distance[M]);
			System.out.print("1 ");
			
			for (int i = arr.size()-1; i >=0; i--) {
				if(arr.get(i)!=0)
				System.out.print(arr.get(i)+" ");
			}
			//System.out.println(Arrays.toString(path));
			
	}
	static boolean Allvisited() {
		for (int i = 1; i <=N; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
	}
	static class NextV{
		int vNum,len;
		NextV(int v,int l){
			vNum=v;
			len=l;
		}
	}


}
