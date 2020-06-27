
// ( () () ) ---> count = 3

import java.util.*;
	class CountBrackets {
	    public static void main(String args[] ) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        String str = sc.next();

	        char[] ch = new char[str.length()]; 

	        for (int i = 0; i < str.length(); i++) { 
	            ch[i] = str.charAt(i); 
	        } 

	        int count = 0;
	        int lbrace = 0;
	        int rbrace = 0;
	        for(int i=0;i<ch.length;i++) {
	            if(ch[i] == '(') {
	                lbrace = lbrace + 1;
	            } else if( ch[i] == ')') {
	                rbrace = rbrace + 1;
	            }
	        }
	        if(lbrace == rbrace) {
	            count = lbrace;
	            
	        } else if(lbrace>rbrace) {
	            count = rbrace;
	        } else {
	            count = lbrace;
	        }
	        System.out.println(count);
	    }
	}
