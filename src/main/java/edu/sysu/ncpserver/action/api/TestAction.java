package edu.sysu.ncpserver.action.api;

import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.Map;

/**
 * Created by mura on 4/12/16
 */
public class TestAction extends JSONAction {

    ////////////////////////////////////////////////////////////////////////////////
    // doExecute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doExecute(Map<String, Object> out) throws Exception {
        System.out.println("--------- --------- TestAction --------- ---------");
        System.out.println("Time: " + new Date());
        System.out.println("URI: " + ServletActionContext.getRequest().getRequestURI());
        Map<String, String[]> paras = ServletActionContext.getRequest().getParameterMap();
        for (String key : paras.keySet()) {
            for (String value : paras.get(key)) {
                System.out.println(key + ": " + value);
            }
            out.put(key, paras.get(key));
        }
        System.out.println("---------- ---------- Finish ---------- ----------");
    }
}
