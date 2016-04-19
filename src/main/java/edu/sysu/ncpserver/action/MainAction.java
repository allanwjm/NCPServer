package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by mura on 3/29/16
 */
public class MainAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {
        // Check login status
        Boolean login = (Boolean) ActionContext.getContext().getSession().get("login");
        if (login != null && login) {
            return SUCCESS;
        } else {
            return LOGIN;
        }
    }

}
