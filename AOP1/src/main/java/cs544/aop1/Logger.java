package cs544.aop1;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.*;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * Created by Adonai on 6/7/2017.
 */
@Aspect
public class Logger{
    @After("execution(* cs544.aop1.EmailSender.sendEmail(..)) && args(email, message)")
    public void logger(JoinPoint j, String email, String message){
        System.out.println(new Date() + " method = " + j.getSignature().getName());
        System.out.println("message = " + message + " address = " + email);
        EmailSender es = (EmailSender)j.getTarget();
        System.out.println("Outgoing mail server: " + es.getOutgoingMailServer());
    }

    @Around("execution(* cs544.aop1.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute: " + totaltime + "ms");
        return retVal;
    }
}
