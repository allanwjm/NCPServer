package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.sysu.ncpserver.HibernateFactory;
import edu.sysu.ncpserver.model.ComplainForm;
import edu.sysu.ncpserver.model.ComplainProgress;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

/**
 * Created by mura on 4/11/16
 */
public class DetailAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Action Fields
    ////////////////////////////////////////////////////////////////////////////////
    // Detail ComplainForm
    private ComplainForm form;

    // Related Progresses
    private List<ComplainProgress> progresses;

    // New Form Id
    private Long formId;

    // Detail error message
    private String error;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {
        Map<String, Object> sess = ActionContext.getContext().getSession();
        if (formId != null && formId != 0) {
            // Load an new ComplainForm
            Session session = HibernateFactory.openSession();
            ComplainForm newForm = session.get(ComplainForm.class, formId);
            session.close();

            // If Hibernate returned null
            if (newForm == null) {
                error = "无效的formId: " + formId + "!";
                return INPUT;
            }

            assign(newForm);
        } else {
            // Check current session. If there is no current ComplainForm, try to get one with Hibernate.
            if (sess.get("complainForm") == null) {
                // Don't have any ComplainForm instance
                error = "请先从投诉列表中选取一条投诉记录!";
                return INPUT;
            }
            assign((ComplainForm) sess.get("complainForm"));
        }

        // Success! Goto Detail page.
        return SUCCESS;
    }

    // Assign Fields
    @SuppressWarnings("unchecked")
    private void assign(ComplainForm form) {
        // Assign ComplainForm
        Map<String, Object> sess = ActionContext.getContext().getSession();
        sess.put("complainForm", form);
        this.form = form;

        // Assign Progresses
        Session session = HibernateFactory.openSession();
        this.progresses = session.createQuery("from ComplainProgress as p where p.formId = :formId").
                setLong("formId", form.getFormId()).list();
        session.close();
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public ComplainForm getForm() {
        return form;
    }

    public void setForm(ComplainForm form) {
        this.form = form;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ComplainProgress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<ComplainProgress> progresses) {
        this.progresses = progresses;
    }
}
