package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by mura on 3/30/16
 */
public class LogoutAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {
        // Clear Session and goto login page
        ActionContext.getContext().getSession().remove("login");
        return LOGIN;
    }
}
