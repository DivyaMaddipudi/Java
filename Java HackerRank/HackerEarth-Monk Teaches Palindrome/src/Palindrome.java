import java.util.Scanner;;

public class Palindrome {
    	    public static void main(String args[] ) throws Exception {
    	        
    	        Scanner s = new Scanner(System.in);
    	        int num = s.nextInt();
    	        String[] str = new String[num];
    	        for(int i=0;i<num;i++) {
    	            str[i] = s.next();
    	        }        
    	       for (String st : str) {
    	            reverse(st);
    	        }
    	    }
    	    
    	    public static void reverse(String st) {
    	    	int len = st.length();
    	    	String rev = "";
    	    	for(int i= len -1;i>=0;i-- ) {
    	    		rev = rev + st.charAt(i);
    	    	}
    	    	
    	    	if((st.equals(rev)) && (len%2 == 0)) {
    	    		System.out.println("YES " + "EVEN");
    	    	} else if((st.equals(rev)) && (len%2 != 0)) {
    	    		System.out.println("YES " + "ODD");
    	    	} else {
    	    		System.out.println("NO");
    	    	}
    	    }
    	    
    	 }
    	        

