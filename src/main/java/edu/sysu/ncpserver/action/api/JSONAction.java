package edu.sysu.ncpserver.action.api;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mura on 3/29/16
 * This class is an abstract class for Actions to return JSON as result.
 */
public abstract class JSONAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Properites
    ////////////////////////////////////////////////////////////////////////////////
    // Result JSON and getter
    private Map<String, Object> out = new TreeMap<>();

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {
        try {
            doExecute(out);
            return SUCCESS;
        } catch (ServerException e) {
            ActionContext.getContext().getValueStack().set("errorMessage", e.getMessage());
        }
        return ERROR;
    }

    // doExecute(), do custom operation here.
    protected abstract void doExecute(Map<String, Object> out) throws Exception;

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public Map<String, Object> getJsonResult() {
        return out;
    }
}
