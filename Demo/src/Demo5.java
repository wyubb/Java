
public class Demo5 {
	public static void main(String args[]) {
		for(int i = 3;i<=100;i++) {
			int k = 0;
			for( k=2;k<=(i-1);k++) {
					if(i%k == 0) {
						break;
					}			
			}
			if(k==i) {
					System.out.println( i+"ÊÇËØÊý");
					}
		}		
	}
}
