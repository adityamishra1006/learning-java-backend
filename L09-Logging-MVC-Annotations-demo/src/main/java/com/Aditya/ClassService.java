package com.Aditya;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "class.service", name = "enable", havingValue = "true")
public class ClassService {
    public String getSessionDetails(){
        return "Session Details";
    }
}
