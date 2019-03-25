package com.ssafy.algo;

import java.util.Scanner;

public class Solution {
	
	static int day;
	static int month;
	static int month3;
	static int year;
	static int[] arr;
	static int tot;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int i = 1; i <=T; i++) {
			day=sc.nextInt();
			month=sc.nextInt();
			month3=sc.nextInt();
			year=sc.nextInt();
			arr=new int[13];
			for (int j = 1; j <=12; j++) {
				arr[j]=sc.nextInt();
			}
			tot=year;
			dfs(1,0);
			System.out.println("#"+i+" "+tot);
		}
	}
	static void dfs(int m,int money) {
		if(m>12) {
			if(tot>money) {
				tot=money;
			}
			return;
		}
		dfs(m+1,day*arr[m]+money);
		dfs(m+1,month+money);
		dfs(m+3,month3+money);
	}
}

/*
10
10 40 100 300                                     
0 0 2 9 1 5 0 0 0 0 0 0                           
10 100 50 300                                     
0 0 0 0 0 0 0 0 6 2 7 8                           
10 70 180 400                                     
6 9 7 7 7 5 5 0 0 0 0 0                          
10 70 200 550                                    
0 0 0 0 8 9 6 9 6 9 8 6                          
10 80 200 550                                    
0 8 9 15 1 13 2 4 9 0 0 0
10 130 360 1200
0 0 0 15 14 11 15 13 12 15 10 15
10 180 520 1900
0 18 16 16 19 19 18 18 15 16 17 16
10 100 200 1060
12 9 11 13 11 8 6 12 8 7 15 6
10 170 500 1980
19 18 18 17 15 19 19 16 19 15 17 18
10 200 580 2320
12 28 24 24 29 25 23 26 26 28 27 22

*/