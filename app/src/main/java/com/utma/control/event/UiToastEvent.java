package com.utma.control.event;

public class UiToastEvent {
    private String message;
    private Boolean longToast, isWarning;
    public UiToastEvent(String message, Boolean longToast, Boolean isWarning){
        this.message = message;
        this.longToast = longToast;
        this.isWarning = isWarning;
    }

    public String getMessage(){return this.message;}
    public void setMessage(String message){
        this.message=message;
    }

    public Boolean getLongToast(){return this.longToast;}
    public void setLongToast(Boolean longToast){
        this.longToast = longToast;
    }

    public Boolean getisWarning(){return this.isWarning;}
    public void setIsWarning(Boolean isWarning){
        this.isWarning=isWarning;
    }

}
