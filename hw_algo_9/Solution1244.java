package edu.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int num = sc.nextInt();
			int change = sc.nextInt();
			int data[] = new int[Integer.toString(num).length()];
			for (int j = Integer.toString(num).length() - 1; j >= 0; j--) {
				data[j] = num % 10;
				num /= 10;
			}

			int count=0;
			for (int j = 9; j >=0; j--) {
				int max_end=0;
				int temp_count=0;
				int temp[]=new int[data.length];
				for (int j1 = 0; j1 < temp.length; j1++) {
					temp[j1]=10;
				}
				for (int j2 = data.length-1; j2 >= 0; j2--) {
					if(j==data[j2]) {
						max_end=j2;
						count++;
					}
				}
				for (int j2 = 0; j2 < max_end; j2++) {
					if(data[j2]<j&&change>0&&count>0) {
						change--;
						count--;
						temp[j2]=data[j2];
						temp_count++;
					}
				}
				for (int k = 0; k < temp.length; k++) {
					//System.out.print(temp[k]);
				}
				//System.out.println();
				//Arrays.sort(temp);//000000???
				for (int k2 = 0; k2 < temp_count; k2++) {
							int min_temp=0;
					for (int k = 1; k < temp.length; k++) {
						if(temp[min_temp]>temp[k]) {
							min_temp=k;
						
						}
					}
					if (temp[min_temp]!=10) {
						for (int k = data.length-1; k >=max_end; k--) {
							if(j==data[k]) {
								int tmp;
								tmp=data[min_temp];
								data[min_temp]=data[k];
								data[k]=tmp;
							}
						}
					}
					temp[min_temp]=10;
		
				}

			}
			int same = 0;
			if (change != 0) {
				for (int j = 0; j < data.length - 1; j++) {
					for (int j3 = j + 1; j3 < data.length; j3++) {
						if (data[j] == data[j3]) {
							same = 1;
							j = data.length - 1;
							change = 0;
							break;
						}
					}
				}
			}
			while (change != 0) {
				int temp;
				temp = data[data.length - 1];
				data[data.length - 1] = data[data.length - 2];
				data[data.length - 2] = temp;
				change--;
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < data.length; j++) {
				System.out.print(data[j]);
			}
			System.out.println();
		}

	}

}