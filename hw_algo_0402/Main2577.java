package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2577 {
	//초밥 종류 최대로
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine().trim());
		int N=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int[] chobab=new int[k];
		int[] tmp=new int[d+1];
		
		Queue<Integer> queue=new LinkedList<>();
		int max=0;
		int count=0;
		tmp[c]++;
		for (int i = 0; i < k; i++) {
			chobab[i]=Integer.parseInt(br.readLine());
			if(tmp[chobab[i]]==0) {
				count++;
			}
			queue.add(chobab[i]);
			tmp[chobab[i]]++;
		}
		
		
		for (int i = k; i <N; i++) {
			if(count>max) {
				max=count;
			}
			int cho=Integer.parseInt(br.readLine());
			int del=queue.poll();
			if(tmp[del]==1) {
				count--;
			}
			tmp[del]--;
			queue.add(cho);
			if(tmp[cho]==0) {
				count++;
			}
			tmp[cho]++;
		}
		for (int i = 0; i <k; i++) {
			if(count>max) {
				max=count;
			}
			int del=queue.poll();
			if(tmp[del]==1) {
				count--;
			}
			tmp[del]--;
			queue.add(chobab[i]);
			if(tmp[chobab[i]]==0) {
				count++;
			}
			tmp[chobab[i]]++;
			
		}
		if(count>max) {
			max=count;
		}
		System.out.println(max+1);
	}

}
