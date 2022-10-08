package weide;

public class Demo02 {
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {			
			for(int k=4; k>=i; k--) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}	
		
		for(int i=0; i<4; i++) {
			for(int k=0; k<=i+1; k++) {
				System.out.print(" ");
			}			
			for(int j=0; j<4-i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
}
