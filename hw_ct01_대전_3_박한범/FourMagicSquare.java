

import java.util.Arrays;
import java.util.Scanner;

public class FourMagicSquare {
	private int[][] magic;//객체 안에서만 사용가능
	// int[][] magic;//패키지 안에서만 사용가능
	private int n;
	//생성자 안만들면  default 생성자가 만들어진다.
	public FourMagicSquare(int n) {
		//super();//지워도 자동으로 불러짐?
		magic=new int[n][n];
		this.n=n;//이름이 다르면 this 안붙여도 됨
//		for (int i = 0; i < magic.length; i++) {
//			Arrays.fill(magic[i], -1);
//		}
	}
	public int[][] getMagic(){
		return magic;
	}
	//있는데 또 태우면 오버로딩
	public FourMagicSquare() {
		//this 생성자 위에 코딩하면 에러남. super와 this를 동시에 사용하면 안됨.
		this(4);//위에꺼 불러서 초기화함
	}
	public void make() {
		makeA();
		makeR();
	}
	
	private void makeR() {
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				if((i>=0&&i<n/4)||(i>=n/4*3&&i<n)) {//맨위나 맨아래
					if(j>=n/4&&j<n/4*3) {
						magic[i][j]=n*n-(i*n+j);
					}
				}else {
					if((j>=0&&j<n/4)||(j>=n/4*3&&j<n)) {
						magic[i][j]=n*n-(i*n+j);
					}
				}
			}
		}
	}
	private void makeA() {
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				magic[i][j]=i*n+j+1;
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
		FourMagicSquare odd=new FourMagicSquare(n);
		odd.make();
		odd.print();
	}
}
