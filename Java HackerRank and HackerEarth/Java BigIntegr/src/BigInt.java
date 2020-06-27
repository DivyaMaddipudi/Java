import java.io.*;
import java.util.*;
import java.math.BigInteger;  


public class BigInt {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        
        
        BigInteger add = a.add(b);

        BigInteger mul = a.multiply(b);
        
        System.out.println(add);
        System.out.println(mul);

    }
}