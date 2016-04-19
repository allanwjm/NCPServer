package edu.sysu.ncpserver; /**
 * Created by mura on 4/1/16.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LifecycleListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public LifecycleListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        HibernateFactory.openSession().close();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        HibernateFactory.close();
    }

}
