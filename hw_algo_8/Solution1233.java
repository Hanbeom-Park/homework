package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1233 {
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int n=0;
			while(N>Math.pow(2, n)) {
				n++;
			}
			int max=(int)Math.pow(2, n);
			int min=(int)Math.pow(2,n-1);
			int result=1;
			for (int j = 1; j < N+1; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char a=st.nextToken().charAt(0);
				//System.out.println(a);
				if(j<max&&j>=min) {
					//48
					if(a<48) {
						//System.out.println("a:"+a+" 가 유효하지 않다");
						result=0;
					}
				}
				else if((N/2)<j&&j<min) {
					if(a<48) {
						result=0;
					}
				}else {
					if(a>=48) {
						result=0;
					}
				}
				
			}
			//n 8
			//int now=Integer.parseInt(st.nextToken());
			System.out.println("#"+i+" "+result);
			
		}
	}

}
