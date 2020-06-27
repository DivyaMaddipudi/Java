/*
 * 
 * Ip:
 * 2
	6 3 (no of buildings in 1st street, cost)
	8 2 3 11 11 10
	---------------
	5 12 (no of buildings in 1st street, cost)
	12 20 39 45 89
	
	op:
	6
	-------
	60
 * There are two streets in the city.

	The first street has 6 buildings and the earning of Napoleon for communicating with each building is 3 Rs..
	
	Height of buildings are 8 2 3 11 11 10 respectively.
	
	As Chef is standing at point , he will be able to see only 1st and 4th building.
	
	So his total earning will be 3*2 = 6 Rs. in that street
	
	Similarly for 2nd street his earning will be 60Rs.

 */
import java.util.*;

class MaxEarning {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        int count;
        
        while(num !=0) {

            int totbuilds = s.nextInt();
            int cost = s.nextInt();
            int[] build = new int[totbuilds];
            for(int i=0;i<totbuilds;i++) {
                build[i] = s.nextInt();
            }
            int max = build[0];
            count = 1;
            for(int i=0;i<totbuilds;i++) {
            	if(build[i] > max) {
            		max = build[i];
            		count = count + 1;
            	}
            }
            
            int earning = count * cost;
            System.out.println(earning);
            
            num--;
        }
    }
}
