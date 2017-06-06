package cs544.sdi1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Adonai on 6/6/2017.
 */
@Service("greetingService")
public class Greeting {
    @Value("Hello World")
    private String greeting;

    public Greeting(){
    }

    public Greeting(String greeting){
        this.greeting = greeting;
    }

    public void sayHello(){
        System.out.println(greeting);
    }

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }
}
