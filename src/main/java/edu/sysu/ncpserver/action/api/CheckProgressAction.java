package edu.sysu.ncpserver.action.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.sysu.ncpserver.HibernateFactory;
import edu.sysu.ncpserver.model.ComplainForm;
import edu.sysu.ncpserver.model.ComplainProgress;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mura on 4/11/16
 */
public class CheckProgressAction extends JSONAction {

    ////////////////////////////////////////////////////////////////////////////////
    // Action Fields
    ////////////////////////////////////////////////////////////////////////////////
    // Counts JSON String
    private String counts;

    ////////////////////////////////////////////////////////////////////////////////
    // doExecute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doExecute(Map<String, Object> out) throws ServerException {

        // Parse counts JSON String
        Gson gson = new GsonBuilder().create();
        @SuppressWarnings("unchecked")
        Map<String, Double> countsMap = gson.fromJson(counts, TreeMap.class);

        if (countsMap == null) {
            out.put("update", 0);
            return;
        }

        // Check each formId with Hibernate
        boolean update = false;
        List<Map<String, Object>> progressJSONs = new ArrayList<>();
        Session session = HibernateFactory.openSession();
        for (String formIdStr : countsMap.keySet()) {
            Long formId = Long.parseLong(formIdStr);
            ComplainForm form = session.get(ComplainForm.class, formId);
            if (form != null) {
                // This formId is valid, Check ComplainProgress
                @SuppressWarnings("unchecked")
                List<ComplainProgress> progresses =
                        session.createQuery("from ComplainProgress as p where p.formId = :formId").
                                setLong("formId", form.getFormId()).list();
                int countNew = progresses.size();
                int countOld = (int) countsMap.get(formIdStr).doubleValue();
                if (countNew > countOld) {
                    update = true;
                    for (int i = countOld; i < countNew; i++) {
                        progressJSONs.add(progresses.get(i).getJSONMap());
                    }
                }
            }
        }
        session.close();

        out.put("update", update ? 1 : 0);
        if (update) {
            out.put("progresses", progressJSONs);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
