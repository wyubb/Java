package test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class Test {

	public static void main(String args[]){
		
		   
		   try {
	
			   DiaryUtil.xmlToDiary();
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
