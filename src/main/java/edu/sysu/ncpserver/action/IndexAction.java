package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * Created by mura on 3/29/16
 */
@Results({
        @Result(name = ActionSupport.LOGIN, type = "redirectAction", location = "login")
})
public class IndexAction extends ActionSupport {

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
