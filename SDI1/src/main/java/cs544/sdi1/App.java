package cs544.sdi1;

/**
 * Created by Adonai on 6/6/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@ComponentScan
@Configuration
public class App {

    public static void main(String[] args){
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Greeting greetingService = context.getBean("greetingService", Greeting.class);
        greetingService.sayHello();
    }
}
