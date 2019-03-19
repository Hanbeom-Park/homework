package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1239_2 {
	//비트가 하나만 다를 경우 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] map= {"000000","001111","010011","011100","100110","101001","110101","111010"};
		char[] a= {'A','B','C','D','E','F','G','H'};
		int N=sc.nextInt();
		sc.nextLine();
		String ss=sc.nextLine();
		ArrayList<Character> arr=new ArrayList<>();
		for (int i = 0; i <N; i++) {
			boolean check=false;
			for (int j = 0; j <map.length; j++) {
				int tmp=Integer.parseInt(map[j],2);
				int tmp2=Integer.parseInt(ss.substring(i*6, i*6+6),2);
				int res=(tmp^=tmp2);
				//System.out.println(map[j]+" "+ss.substring(i*6, i*6+6)+" "+res);
				if(res==0) {
					arr.add(a[j]);
					check=true;
					break;
				}
				for (int k = 0; k <6; k++) {
					if(res==(1<<k)) {
						arr.add(a[j]);
						check=true;
						break;
					}
				}
				
			}
			if(!check) {
				System.out.println(i+1);
				return;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
		}
	}

}
