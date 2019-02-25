package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Solution1257_2 {

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= T; i++) {
			int index = Integer.parseInt(br.readLine().trim());
			String ss = br.readLine().trim();
			String[] s = new String[ss.length() * (ss.length() + 1) / 2];
			TreeSet<String> ts=new TreeSet<>();
			int count=0;
			for (int j = 1; j < ss.length()+1; j++) {
				for (int j2 =0 ; j2 < ss.length()-j+1; j2++) {
						ts.add(ss.substring(j2, j2+j));
				}
			}
			ArrayList<String> li=new ArrayList<>(ts);
			
			if(ts.size()<index) {
				System.out.println("#"+i+" none");
			}else {
				System.out.println("#"+i+" "+li.get(index-1));
			}
		}

	}

}
/*
1
7
love

1
10
food

*/