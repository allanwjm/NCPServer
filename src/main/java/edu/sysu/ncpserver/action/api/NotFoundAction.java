package edu.sysu.ncpserver.action.api;

import java.util.Map;

/**
 * Created by mura on 4/7/16
 */
public class NotFoundAction extends JSONAction {
    @Override
    protected void doExecute(Map<String, Object> out) throws Exception {
        out.put("error", "404: Page not found!");
    }
}
