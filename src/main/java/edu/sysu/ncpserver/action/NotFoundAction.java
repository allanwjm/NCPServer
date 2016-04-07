package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * Created by mura on 4/7/16
 */
@Results({
        @Result(name = "main", type = "chain", location = "main")
})
public class NotFoundAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        String URI = ServletActionContext.getRequest().getRequestURI();
        if (URI.equals("/") || URI.equals("/index")) {
            return "main";
        }
        return SUCCESS;
    }
}
