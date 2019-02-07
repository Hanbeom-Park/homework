

import java.util.Arrays;
import java.util.Scanner;

public class OddMagicSquare {
	private int[][] magic;
	private int n;
	public OddMagicSquare(int n) {
		magic=new int[n][n];
		this.n=n;
	}
	public OddMagicSquare() {
		this(3);
	}
	public int[][] getMagic(){
		return magic;
	}
	public void make() {
		int x=0;
		int y=n/2;
		for (int i = 1; i <= n*n; i++) {
			this.magic[x][y]=i;
			int tempX=x;
			int tempY=y;
			if(x-1<0) {
				x=n-1;
			}
			else {
				x--;
			}
			if(y-1<0) {
				y=n-1;
			}
			else {
				y--;
			}
			if(magic[x][y]!=0) {
				x=tempX+1;
				y=tempY;
			}
		}
	}
	public boolean isCheck() {
		boolean isS=true;
		int []mm=new int[2*n+2];
		for (int i = 0; i < n; i++) {
			mm[i]=sumRow(i);
			mm[i+n]=sumCol(i);
		}
		mm[2*n]=sumDia();
		mm[2*n+1]=sumAntDia();
		for (int i = 1; i < mm.length; i++) {
			if(mm[0]!=mm[i]) {
				isS=false;
				break;
			}
		}
		return isS;
	}
	private int sumRow(int row) {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[row][i];
		}
		return tot;
	}
	private int sumCol(int col) {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][col];
		}
		return tot;
	}
	private int sumDia() {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][i];
		}
		return tot;
	}
	private int sumAntDia() {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][n-1-i];
		}
		return tot;
	}
	public void oneLine() {
		int tot=((n*n)*(n*n+1))/2;
		int line=tot/n;
		System.out.printf("마방진 전체 합: %d 임의의 한 행의 값: %d\n",tot,line);
	}
	public void print() {
		System.out.printf("%d is magic? %b\n",n,isCheck());
		oneLine();
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic[i].length; j++) {
				System.out.printf("%d\t",magic[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		OddMagicSquare odd=new OddMagicSquare(n);
		odd.make();
		odd.print();
	}
}
