package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.sysu.ncpserver.utils.Config;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * Created by mura on 3/29/16
 */
@Results({
        @Result(name = ActionSupport.SUCCESS, type = "redirectAction", location = "index")
})
public class LoginAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // HTTP parameters
    ////////////////////////////////////////////////////////////////////////////////
    // Username
    private String username;
    // Password
    private String password;

    // Error message
    private String errorMessage;

    // Submitted flag
    private Boolean submit;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {

        // If this action is not called by submission of login form, return
        if (submit == null || !submit) {
            return INPUT;
        }

        // Validate username and password
        if (username == null || username.length() == 0) {
            errorMessage = "请输入用户名";
            return INPUT;
        }

        if (password == null || password.length() == 0) {
            errorMessage = "请输入密码";
            return INPUT;
        }

        if (!username.equals(Config.getString("web_username"))
                || !password.equals(Config.getString("web_password"))) {
            errorMessage = "用户名或密码错误";
            return INPUT;
        }

        // Login success
        ActionContext.getContext().getSession().put("login", true);
        return SUCCESS;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getSubmit() {
        return submit;
    }

    public void setSubmit(Boolean submit) {
        this.submit = submit;
    }

}
