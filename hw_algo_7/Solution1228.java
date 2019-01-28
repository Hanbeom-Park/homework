package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1228 {
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			ArrayList<String> ss = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if (j <= 10) {
					ss.add(st.nextToken().trim());
				}else {
					st.nextToken();
				}
			}
			int command = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < command; j++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int number_count = Integer.parseInt(st.nextToken());
				for (int k = 0; k < number_count; k++) {
					if (index + k <= 10) {
						ss.add(index + k, st.nextToken());
					}else {
						st.nextToken();
					}
				}
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(ss.get(j) + " ");
			}
			System.out.println();
		}
	}
}
