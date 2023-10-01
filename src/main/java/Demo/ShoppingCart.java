package Demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status){

        //Logging
        //Authentication and Authorization
        //Sanitization of Data
        System.out.println("Checkout method from ShoppingCart class");
    }

    public int quantity(){
        return 2;
    }
}
