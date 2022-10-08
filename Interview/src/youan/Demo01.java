package youan;

public class Demo01 {
	public static void main(String[] args) {
		
		String str = "a,b,c,d,e,f,g";
		
		String[] strSplit= str.split(",");
		for(int i=0; i<strSplit.length; i++) {
			System.out.println(strSplit[i]+"1");
		}
	}
}
