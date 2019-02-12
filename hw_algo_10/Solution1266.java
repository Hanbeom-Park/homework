package edu.ssafy.algo;

import java.util.Scanner;

public class Solution1266 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] prime= {2,3,5,7,11,13,17};
		int[] combination= {153,816,8568,31824,31824,8568,18};
		for (int i = 1; i <=T; i++) {
			double A=sc.nextDouble();
			double B=sc.nextDouble();
			//18개
			//AorB
			//2 3 5 7 11 13 17 1/18
			//(A/100
			double Asum=0;
			double Bsum=0;
			
			for (int j = 0; j < prime.length; j++) {				
				double resA=1;
				double resB=1;
				resA=resA*combination[j];
				resB=resB*combination[j];
				for (int j2 = 0; j2 <prime[j]; j2++) {
					resA=resA*A/100;
					resB=resB*B/100;
				}
				for (int j2 = prime[j]; j2 <18 ; j2++) {
					resA=resA*(100-A)/100;
					resB=resB*(100-B)/100;
					
				}
				Asum=Asum+resA;
				Bsum=Bsum+resB;
			}
			double result=1-((1-Asum)*(1-Bsum));
			System.out.printf("#%d %.6f\n",i,result);
		}
	}
}
/*
10
0 0
80 90
10 20
1 2
100 100
60 23
70 23
80 32
90 32
100 32

*/
