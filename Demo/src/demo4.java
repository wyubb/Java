
public class demo4 {
	public static void main(String args[]) {
		int i;
		int j;
		long sum=0;
		for ( i = 1;i <11 ;i++) {
			long  k=1;
			for(j = 1;j<= i;j++) {
				k=k*j;
			}
			System.out.println(k);
			sum+=k;
		}
		
		System.out.println(sum);
	}
		
		 
}

