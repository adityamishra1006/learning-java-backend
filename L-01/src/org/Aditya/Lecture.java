package org.Aditya;

import java.util.List;

public class Lecture {
    String title;

    String mentor;
    
    String status;
    
    List<String> resources;

    static Integer totalObjects = 0;

    public Lecture(String title, String mentor, String status) {
        this.title = title;
        this.mentor = mentor;
        this.status = status;
        totalObjects++;
    }


    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public String downloadResources(){
        return "";
    }

    public void join(){

    }
}
