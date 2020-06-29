import java.util.*;

class MonkAndPowerOfTime {
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);

		int numberOfProcesses = s.nextInt();
		int[] callOrder = new int[numberOfProcesses];
		int[] idealOrder = new int[numberOfProcesses];

		for(int i=0;i<numberOfProcesses;i++) {
			callOrder[i] = s.nextInt();
		}

		for(int i=0;i<numberOfProcesses;i++) {
			idealOrder[i] = s.nextInt();
		}

		int count = 0;
		int sum = 0;
		for(int i=0;i<numberOfProcesses;i++) {
			if(callOrder[i] != idealOrder[i]) {
				while(callOrder[i] != idealOrder[i]) {

					int temp = callOrder[0];
					for(int k=0;k<numberOfProcesses-1;k++) {
						callOrder[k] =  callOrder[k + 1];
					}
					callOrder[numberOfProcesses - 1] = temp;	
					count = count + 1;	
				}
			} else if(callOrder[i] == idealOrder[i]) {
				count = count + i;
			}
		}
		System.out.println(count);
	}    
}

