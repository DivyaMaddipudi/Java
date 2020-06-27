import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.NumberFormat; 
import java.util.Locale;



public class CurrencyFormatter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat formatter=NumberFormat.getCurrencyInstance(new Locale("en", "US")); 
        String us=formatter.format(payment);  

        NumberFormat formatter1=NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        String india=formatter1.format(payment);  

        NumberFormat formatter2=NumberFormat.getCurrencyInstance(Locale.CHINA); 
        String china=formatter2.format(payment);  

        NumberFormat formatter3=NumberFormat.getCurrencyInstance(Locale.FRANCE); 
        String france=formatter3.format(payment);  
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
