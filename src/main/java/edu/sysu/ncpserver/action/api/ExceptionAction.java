package edu.sysu.ncpserver.action.api;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import java.util.Map;

/**
 * Created by mura on 3/31/16
 */
public class ExceptionAction extends JSONAction {

    ////////////////////////////////////////////////////////////////////////////////
    // Action Fields
    ////////////////////////////////////////////////////////////////////////////////
    // Error message
    String error;

    ////////////////////////////////////////////////////////////////////////////////
    // doExecute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doExecute(Map<String, Object> out) throws Exception {
        String message;
        if (error != null) {
            message = error;
        } else {
            message = ActionContext.getContext().getValueStack().findString("errorMessage");
        }
        out.put("error", message);
        ServletActionContext.getResponse().setStatus(500);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
