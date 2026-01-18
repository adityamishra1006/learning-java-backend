package org.gfg.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class NotificationService {
    @Autowired
    private SMSGatewayService smsgatewayService;

//    public NotificationService(SMSGatewayService smsgatewayService){
//        this.smsgatewayService = smsgatewayService;
//    }


//    @Autowired
//    public void setSmsgatewayService(SMSGatewayService smsgatewayService) {
//        this.smsgatewayService = smsgatewayService;
//    }

    public void sendNotification(String message) {
        smsgatewayService.sendSMS(message);
    }

    public SMSGatewayService getSmsgatewayService() {
        return smsgatewayService;
    }
}
