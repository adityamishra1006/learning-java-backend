package org.gfg.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.gfg.annotation");
        NotificationService notificationService = applicationContext.getBean("notificationService", NotificationService.class);
        notificationService.sendNotification("OTP: 873949");

        SMSGatewayService smsGatewayService = applicationContext.getBean("SMSGatewayService", SMSGatewayService.class);


        System.out.println(smsGatewayService == notificationService.getSmsgatewayService());
    }
}
