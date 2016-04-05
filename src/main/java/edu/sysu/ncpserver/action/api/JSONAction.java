package edu.sysu.ncpserver.action.api;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mura on 3/29/16
 * This class is an abstract class for Actions to return JSON as result.
 */
@ParentPackage("json-default")
@Results({
        @Result(name = ActionSupport.SUCCESS, type = "json", params = {"root", "jsonResult"}),
        @Result(name = ActionSupport.ERROR, type = "redirectAction", location = "api/exception",
                params = {"message", "${exceptionMessage}"})
})
public abstract class JSONAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Properites
    ////////////////////////////////////////////////////////////////////////////////
    // Result JSON and getter
    private Map<String, Object> out = new TreeMap<>();

    // Exception message
    private String exceptionMessage;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {
        try {
            doExecute(out);
            return SUCCESS;
        } catch (ServerException e) {
            exceptionMessage = e.getMessage();
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

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
