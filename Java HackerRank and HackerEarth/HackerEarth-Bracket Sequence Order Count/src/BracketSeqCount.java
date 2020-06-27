/*
 * we need to find no.of correct sequences possible by shifting(cyclic) the given sequence.

	ex : ) ( ) ( ) (
	
	all possible sequences are:  sequence for i --> s[i],s[i+1],..s[n],s[1],s[2],..s[i-1] 
	
	i=1 --> ) ( ) ( ) (  
	
	i=2 --> ( ) ( ) ( )
	
	i=3 --> ) ( ) ( ) ( 
	
	i=4 --> ( ) ( ) ( )
	
	i=5 --> ) ( ) ( ) ( 
	
	i=6 --> ( ) ( ) ( )
	
	for i=2,4,6 sequences are correct. hence, output = 3

 */

import java.util.*;

class BracketSeqCount {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
	        String str = sc.next();

	        char[] ch = new char[str.length()]; 

	        for (int i = 0; i < str.length(); i++) { 
	            ch[i] = str.charAt(i); 
	        } 
	int min = 100;
	int count = 0;
	int bal = 0;
	for(int i=0;i<ch.length;i++)
    {
      if(ch[i]==')')
      count--;
       else
      count++;
      if(min>count)
      {
        min=count;
        bal=0;
      }
      if(min==count)
      bal++;
 
   }
   if(count==0)
   {
      System.out.println(bal);
   }
   else
   System.out.println("0");
   
}
        
}
