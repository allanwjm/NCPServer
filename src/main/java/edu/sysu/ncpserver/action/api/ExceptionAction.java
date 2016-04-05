package edu.sysu.ncpserver.action.api;

import org.apache.struts2.ServletActionContext;

import java.util.Map;

/**
 * Created by mura on 3/31/16
 */
public class ExceptionAction extends JSONAction {

    ////////////////////////////////////////////////////////////////////////////////
    // Properites
    ////////////////////////////////////////////////////////////////////////////////
    // Exception message
    private String message;

    @Override
    protected void doExecute(Map<String, Object> out) throws Exception {
        out.put("error", message);
        ServletActionContext.getResponse().setStatus(500);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
