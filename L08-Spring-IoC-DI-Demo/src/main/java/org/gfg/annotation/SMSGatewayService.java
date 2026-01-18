package org.gfg.annotation;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SMSGatewayService {
    public SMSGatewayService() {
        // Default constructor
    }

    public void sendSMS(String msg){
        System.out.println("Sending " + msg);
    }

//    @PostConstruct init method
    public void init(){
        System.out.println("SMSGatewayService bean is being initialized");
    }


//    @PreDestroy destroy method
    public void destroy() {
        System.out.println("SMSGatewayService bean is being destroyed");
    }

}
