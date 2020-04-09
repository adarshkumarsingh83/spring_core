package com.espark.adarsh;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.espark.adarsh.service.*;
import com.espark.adarsh.configuration.*;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.start();
        final MyService myService=context.getBean(MyServiceImpl.class);
        myService.getMessage();
        context.stop();
    }
}
