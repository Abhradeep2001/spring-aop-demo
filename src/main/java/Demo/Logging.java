package Demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    //To execute "loggers" function before "checkout" function in ShoppingCart Class (Point-Cut)
    @Before("execution(* Demo.ShoppingCart.checkout(..))")
    public void beforeLoggers(JoinPoint jp){

//        To return the type of signature(argument) we are passing to the method
        System.out.println(jp.getSignature());

//        Return the 1st arg of the array of arguments and convert it into string
        String arg1 = jp.getArgs()[0].toString();
        System.out.println("Before loggers with argument "+ arg1);
    }
    //To execute "loggers" function after "checkout" function in Shoppingcart Class (Point-Cut)
    @After("execution(* *.*.checkout(..))")
    public void afterLoggers(JoinPoint jp){

//        To return the type of signature(argument) we are passing to the method
        System.out.println(jp.getSignature());

//        Return the 1st arg of the array of arguments and convert it into string
        String arg2 = jp.getArgs()[0].toString();
        System.out.println("After Loggers with argument "+ arg2);
    }

    @Pointcut("execution(* Demo.ShoppingCart.quantity())")
    public void afterReturningPointCut(){

    }
    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal){
        System.out.println("After returning "+ retVal);
    }

}
