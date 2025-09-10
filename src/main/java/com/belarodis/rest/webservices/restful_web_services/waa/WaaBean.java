package com.belarodis.rest.webservices.restful_web_services.waa;

public class WaaBean {
    private String message;

    public WaaBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WaaBean [message=" + message + "]";
    }
}
