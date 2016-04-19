package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.sysu.ncpserver.HibernateFactory;
import edu.sysu.ncpserver.model.ComplainForm;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by mura on 3/14/16
 */
public class QueryAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Action Fields
    ////////////////////////////////////////////////////////////////////////////////
    // Queried ComplainForm list
    private List<ComplainForm> formList;

    // Error Message
    private String errorMessage;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    @SuppressWarnings("unchecked")
    public String execute() {

        Session session = HibernateFactory.openSession();
        session.beginTransaction();
        formList = session.createQuery("from ComplainForm").list();
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
