package com.maven.DependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interfaces.car.Cars;
import com.maven.Interfaces.Celerio;
import com.maven.Interfaces.Swift;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cars swift = new Swift();
        System.out.println(swift.cars());
        
        Cars celerio = new Celerio();
        System.out.println(celerio.cars());
        
//        Vehicle swift1 = new Swift();
//        System.out.println(swift1.cars());
        
        // Creating Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        
        Cars myCar = (Cars) context.getBean("car");
        System.out.println(myCar.cars());
        
        // Creating bean another method in spring IDE
        
        AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(AppConfig.class);
        Cars myCars = contex.getBean("celerio", Cars.class);
        System.out.println(myCars.cars());
        contex.close();
       
    }
}
