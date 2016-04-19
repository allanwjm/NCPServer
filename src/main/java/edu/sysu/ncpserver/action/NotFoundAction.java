package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * Created by mura on 4/7/16
 */
public class NotFoundAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Action Fields
    ////////////////////////////////////////////////////////////////////////////////
    private String lostURI;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {
        String URI = ServletActionContext.getRequest().getRequestURI();
        if (URI.equals("/") || URI.equals("/index")) {
            return "main";
        }
        lostURI = URI;
        return SUCCESS;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getLostURI() {
        return lostURI;
    }

    public void setLostURI(String lostURI) {
        this.lostURI = lostURI;
    }
}
