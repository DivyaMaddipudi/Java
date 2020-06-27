import java.util.Scanner;
class TestClass {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        int tot = s.nextInt();
        
        int count = 0;
        while(tot!=0) {

            int N = s.nextInt();
            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    
                    for(int i1=i;i1<N;i1++) {
                        for(int j1=j;j1<N;j1++) {
                            if(arr[i][j] > arr[i1][j1]){
                                count = count + 1;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
            tot--;
            count = 0;
        }
        
    }
}
