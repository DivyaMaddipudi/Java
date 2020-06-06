import java.util.Scanner;

class GoodVowelString {
	
	static char[] vow = new char[]{'a','e','i','o','u'};
    public static void main(String args[] ) throws Exception {


        Scanner s = new Scanner(System.in);
        String str = s.nextLine();    
        
        String res = "";
        for(int i=0;i<str.length();i++) {
            for(int j=i+1;j<=str.length();j++) {
                res = res + str.substring(i,j) + " ";
            }
        }
        String[] data = res.split(" ");
        
        for(String x: data) {
        	System.out.println(vowel(x));
        }
	}
	public static String vowel(String x) {
		String val = "";
		

		for(int i=0;i<x.length();i++) {
			if(x == vow[i]) {
				
			}
			
		}
		return val;
    }
}
