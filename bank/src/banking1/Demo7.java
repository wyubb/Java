package banking1;

public class Demo7 {
	public static void mian(String args[]) {
	for(int i=1;i<=1000;i++) {
		int sum =0;
		for(int j=1;j<=i;j++) {
			if(i%j ==0) {
				sum += j;
			}
		}
		if(sum==i) {
			System.out.println(i);
		}
	}
	}
}
