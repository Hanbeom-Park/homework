package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.algo.BinarySearch.TreeNode;

public class Solution1233_2 {
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int n=0;
			int result;
			Tree tree=new Tree();
			for (int j = 1; j < N+1; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree.insert(j,st.nextToken().charAt(0));
			}
			if(tree.postorder()==true) {
				result=1;
			}else {
				result=0;
			}
			//n 8
			//int now=Integer.parseInt(st.nextToken());
			System.out.println("#"+i+" "+result);
			
		}
	}

}
class Tree{
	private char[] data=new char[256];
	private boolean result=true;
	Tree(){
		
	}
	public void insert(int i,char c) {
		//index++;
		while(i>data.length) {
			char[] tmp=data.clone();
			int len=data.length;
			data=new char[len*2];
			System.arraycopy(tmp, 0, data, 0, tmp.length);
		}
		data[i]=c;
	}
	public void find_last(int now) {
		if(now*2<data.length||data[now*2]=='\u0000') {
			//if(data[now]>"")
			return;
		}
		find_last(now*2);
		find_last(now*2+1);
	}
	private void postorder(int n) {
		//System.out.print(n.data+" ");
		if(n*2>=data.length||data[n*2]=='\u0000') {
			if(data[n]<48) {
				result=false;
			}
			return;
		}
		if(data[n]>=48) {
			result=false;
		}
		postorder(n*2);
		postorder(n*2+1);
		
	}

	public boolean postorder() {

		postorder(1);
		boolean a=result;
		result=true;
		return a;
	}

	
}