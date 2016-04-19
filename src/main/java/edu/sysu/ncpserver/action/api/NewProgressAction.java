package edu.sysu.ncpserver.action.api;

import edu.sysu.ncpserver.HibernateFactory;
import edu.sysu.ncpserver.model.ComplainProgress;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

/**
 * Created by mura on 4/12/16
 */
public class NewProgressAction extends JSONAction {

    ////////////////////////////////////////////////////////////////////////////////
    // Action Fields
    ////////////////////////////////////////////////////////////////////////////////
    // ComplainProgress instance
    private ComplainProgress progress = new ComplainProgress();

    // FormId
    private String formIdStr;

    ////////////////////////////////////////////////////////////////////////////////
    // doExecute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doExecute(Map<String, Object> out) throws Exception {
        Long formId = Long.parseLong(formIdStr);
        if (progress.isValid() && formId != 0) {
            Session session = HibernateFactory.openSession();
            @SuppressWarnings("unchecked")
            List<ComplainProgress> progresses =
                    session.createQuery("from ComplainProgress as p where p.formId = :formId").
                            setLong("formId", formId).list();
            int count = progresses.size();
            progress.attachToForm(formId, count);
            session.beginTransaction();
            session.save(progress);
            session.getTransaction().commit();
            session.close();
            out.put("progressId", progress.getProgressId());
        } else {
            throw new ServerException("受理进度记录信息不完整, 无法添加");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getTitle() {
        return progress.getTitle();
    }

    public void setTitle(String title) {
        progress.setTitle(title);
    }

    public String getComment() {
        return progress.getComment();
    }

    public void setComment(String comment) {
        progress.setComment(comment);
    }

    public String getDetails() {
        return progress.getDetailsJSON();
    }

    public void setDetails(String details) {
        progress.setDetailsJSON(details);
    }

    public String getFormId() {
        return formIdStr;
    }

    public void setFormId(String formId) {
        this.formIdStr = formId;
    }
}
