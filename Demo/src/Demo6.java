
public class Demo6 {
	public static void main(String args[]) {
		int i,j;
		double  sum = 0;
		for(i =1;i<=10;i++) {
			long k=1;
			for(j=1;j<=i;j++) {
				k*=j;
			}
			System.out.println("K:"+k);
			sum =sum+(1.0/k);
			
		}
		System.out.println("Sum:"+sum);
	}
}
