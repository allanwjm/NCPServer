package edu.sysu.ncpserver.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.sysu.ncpserver.model.ComplainForm;
import edu.sysu.ncpserver.model.HeatMapPoint;
import edu.sysu.ncpserver.utils.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mura on 4/4/16
 */
public class HeatMapAction extends ActionSupport {

    ////////////////////////////////////////////////////////////////////////////////
    // Action parameters
    ////////////////////////////////////////////////////////////////////////////////
    // Queried ComplainForm list
    private List<HeatMapPoint> pointList;

    ////////////////////////////////////////////////////////////////////////////////
    // Struts2 Action execute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public String execute() throws Exception {

        // Select form list
        Session session = Hibernate.openSession();
        session.beginTransaction();
        List<ComplainForm> formList = session.createQuery("from edu.sysu.ncpserver.model.ComplainForm").list();
        session.getTransaction().commit();
        session.close();

        // Generate HeatMapPoint list
        pointList = new ArrayList<>();
        for (ComplainForm form : formList) {
            pointList.add(new HeatMapPoint(form));
        }

        return SUCCESS;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public List<HeatMapPoint> getPointList() {
        return pointList;
    }

}
