/*
 * 
 * ip: 10 2 3 4 op: 4
 * ip: 10 2 2 4 op: 0 (Note: If there is collision between the flights no flight will take off on that day.)
 * 
 */

import java.util.*;

class TakeOff{

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int num=sc.nextInt();
      int n,p,q,r,count;
	
	
		for(int i=0;i<num;i++)
		
		
		{
		
		
		n=sc.nextInt();
		
		
		p=sc.nextInt();
		
		
		q=sc.nextInt();
		
		
		r=sc.nextInt();
		
		
		count = 0;
		
		for(int j=1;j<=n;j++)
		{
		
		
		if(j%p == 0 && j%q != 0 && j%r != 0 ||
		
		
		j%p != 0 && j%q == 0 && j%r != 0 ||
		
		
		j%p != 0 && j%q != 0 && j%r == 0)
		
		{	
		count++;
	
		}
		}
		System.out.println(count);
	
		}	
		
	}
	
}
