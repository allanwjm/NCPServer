package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.sysu.ncpserver.model.ComplainForm;
import edu.sysu.ncpserver.utils.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by mura on 3/14/16
 */
public class QueryAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Action parameters
    ////////////////////////////////////////////////////////////////////////////////
    // Queried ComplainForm list
    private List<ComplainForm> formList;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() {

        Session session = Hibernate.openSession();
        session.beginTransaction();
        formList = session.createQuery("from edu.sysu.ncpserver.model.ComplainForm").list();
        session.getTransaction().commit();
        session.close();

        return SUCCESS;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public List<ComplainForm> getFormList() {
        return formList;
    }

}
