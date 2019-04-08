import java.util.*;
public class Example3_9 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		double sum = 0;
		int m = 0;
		while(reader.hasNextDouble()) {
			double x = reader.nextDouble();
			assert x <= 100 && x >= 0 :"这是一个非法的成绩";
			m = m + 1;
			sum = sum + x;
			
		}
		System.out.printf("%d个数的和为%f\n",m,sum);
		System.out.printf("%d个数的平均值是%f\n",m,sum/m);
		
	}
}
