package com.Aditya;

public class Signal {
    private boolean stop;


//    We can use volatile here to ensure visibility across threads
//    We can use synchronize keyword to ensure atomicity
    public boolean isStop(){
        return stop;
    }

    public void setStop(boolean stop){
        this.stop = stop;
    }


}
