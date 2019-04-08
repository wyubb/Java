import java.io.*;
//运算两个矩阵相乘的结果
public class CH02_03 {
	public static void main (String args[]) throws IOException {
		int M,N,P;
		int i,j;
		String StrM;
		String StrN;
		String StrP;
		String tempstr;
		
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("请输入矩阵A的维数（M,N）: ");
		System.out .print("请先输入矩阵A的M值： ");	
		StrM =keyin.readLine();
		M = Integer.parseInt(StrM);	
		
		System.out.print("接着输入矩阵A的N值： ");
		StrN = keyin.readLine();
		N = Integer.parseInt(StrN);
		
		int A[][] =new int[M][N];
		System.out.print("[请输入矩阵A的各个元素]");
		System.out.println("注意！每输入一个值按下Enter键确认输入");
		
		for(i = 0;i < M;i++) {
			for(j = 0;j<N;j++) {
				System.out.print("a" + i + j +"=");
				tempstr=keyin.readLine();
				A[i][j] = Integer.parseInt(tempstr);
				}
			
		}
		
		System.out.println("请输入矩阵B的维数（N,P）: ");
		System.out.print("请先输入矩阵B的N值： ");
		StrN = keyin.readLine();
		N = Integer.parseInt(StrN);
		System.out.print("请先输入矩阵B的P值： ");
		StrP = keyin.readLine();
		P = Integer.parseInt(StrP);
		
		int B[][] = new int[N][P];
		System.out.print("[请输入矩阵	B的各个元素]");
		System.out.println("注意！每输入一个值按下Enter键确认输入");
		
		for(i = 0;i < N;i++) {
			for(j = 0;j<P;j++) {
				System.out.print("b" + i + j +"=");
				tempstr=keyin.readLine();
				B[i][j] = Integer.parseInt(tempstr);
				}
		}
		 int C[][] = new int[M][P];
		 MatrixMultiply(A,B,C,M,N,P);
		 System.out.println("[A*B的结果是]");
		 for(i = 0;i < M;i++) {
				for(j = 0;j<P;j++) {
					System.out.print(C[i][j]);
					System.out.print('\t');
					}
				System.out.println();
			}
	}

	public static void MatrixMultiply(int[][] arrA, int[][] arrB, int[][] arrC, int M, int N, int P) {
		// TODO 自动生成的方法存根
		int i,j,k,Temp;
		if(M <= 0 || N <= 0||P <= 0) {
			System.out.println("[错误：维数M,N,P必须大于0]");
			return;
		}
		for(i = 0;i < M;i ++){
			for(j = 0;j < P;j++) {
				Temp =0;
				for(k = 0;k < N;k++) {
					Temp =Temp +arrA[i][k] * arrB[k][j];
				}
				arrC[i][j] =Temp;
			}
			
		}
	}
}
