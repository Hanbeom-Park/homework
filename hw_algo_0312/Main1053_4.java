package com.ssafy.algo;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main1053_4{
    static int[][] map=new int[100001][4];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        while (true) {
            long N = sc.nextLong();
            if (N == -1) {
                break;
            }
            if (N == 0) {
                System.out.println("0");
            } else {
                int[] res=makeNum(N);
                System.out.println(res[1]%10000);
            }
         
        }
    }
    static int[] makeNum(long N) {
        if(N==1) {
            return new int[]{1, 1, 1, 0};
        }
        if(N<100001) {
            if(map[(int) N][3]!=0) {
                return map[(int) N];
            }
        }
        if(N%2==0) {
            int[] map1=makeNum(N/2);
            int[] map2=makeNum(N/2);
            int[] res=new int[4];
            res[0] = map1[0]*map2[0]%10000+map1[1]*map2[2]%10000;
            res[1] = map1[0]*map2[1]%10000+map1[1]*map2[3]%10000;
            res[2] = map1[2]*map2[0]%10000+map1[3]*map2[2]%10000;
            res[3] = map1[2]*map2[1]%10000+map1[3]*map2[3]%10000;
            if(N<100001) {
            map[(int)N]=res;
            }
            return res;
        }else {
            int[] map1=makeNum(N/2);
            int[] map2=makeNum(N/2+1);
            //System.out.println(Arrays.toString(map1));
            //System.out.println(Arrays.toString(map2));
            //System.out.println("AAA");
            int[] res=new int[4];
            res[0] = map1[0]*map2[0]%10000 + map1[1]*map2[2]%10000;
            res[1] = map1[0]*map2[1]%10000+map1[1]*map2[3]%10000;
            res[2] = map1[2]*map2[0]%10000+map1[3]*map2[2]%10000;
            res[3] = map1[2]*map2[1]%10000+map1[3]*map2[3]%10000;
            if(N<100001) {
            map[(int)N]=res;
            }
            return res;
        }
    }
}