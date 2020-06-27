import java.util.Scanner;

class WelcomeProblem {
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int[] arr1 = new int[num];
        int[] arr2 = new int[num];
       
        int[] sum = new int[num];
        for(int i=0;i<num;i++) {
            arr1[i] = s.nextInt();
        }

        for(int i=0;i<num;i++) {
            arr2[i] = s.nextInt();
        }

        for(int i=0;i<num;i++) {
            sum[i] = arr1[i] + arr2[i];
        }
        
        for(int i=0;i<num;i++) {
            System.out.print(sum[i] + " ");
        }
    }
}
