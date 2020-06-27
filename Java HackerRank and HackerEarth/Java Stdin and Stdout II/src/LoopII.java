import java.util.*;
import java.io.*;
import java.lang.Math; 


class LoopII{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            long sum = 0;
            

            for(int j=0;j<n;j++)
            {

                long pow =  a + Math.round((Math.pow(2,j)*b));

                

                sum = sum + pow ;
                a = 0;
                System.out.printf("%d ",sum);
                
            }
            System.out.println();
            

        }
        in.close();
    }
}
