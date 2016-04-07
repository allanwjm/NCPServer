package edu.sysu.ncpserver.action.api;

import edu.sysu.ncpserver.HibernateFactory;
import edu.sysu.ncpserver.model.ComplainForm;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by mura on 2/29/16
 */
public class ComplainAction extends JSONAction {

    ////////////////////////////////////////////////////////////////////////////////
    // HTTP parameters
    ////////////////////////////////////////////////////////////////////////////////
    // ComplainForm instance. Struts2 will get access to it by getters and setters.
    private ComplainForm form = new ComplainForm();

    ////////////////////////////////////////////////////////////////////////////////
    // doExecute()
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doExecute(Map<String, Object> out) throws Exception {

        // Assign formId
        form.setFormId(generateFormId(form.getDate()));

        // Validate
        if (form.isValid()) {
            // Save ComplainForm with Hibernate
            Session session = HibernateFactory.openSession();
            session.beginTransaction();
            session.save(form);
            session.getTransaction().commit();
            session.close();

            // Return the form ID
            out.put("formId", form.getFormId());
        } else {
            throw new ServerException("表单填写不完整, 无法受理");
        }
    }

    // Generate ComplainForm instance from HTTP parameters
    private long generateFormId(Date date) {

        // Generate Date instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Format form ID
        long formId = (int) (Math.random() * 10000);
        formId += calendar.get(Calendar.SECOND) * Math.pow(10, 4);
        formId += calendar.get(Calendar.MINUTE) * Math.pow(10, 6);
        formId += calendar.get(Calendar.HOUR_OF_DAY) * Math.pow(10, 8);
        formId += calendar.get(Calendar.DAY_OF_MONTH) * Math.pow(10, 10);
        formId += (calendar.get(Calendar.MONTH) + 1) * Math.pow(10, 12);
        formId += calendar.get(Calendar.YEAR) * Math.pow(10, 14);

        return formId;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public String getPlatform() {
        return form.getPlatform();
    }

    public void setPlatform(String platform) {
        form.setPlatform(platform);
    }

    public String getDevId() {
        return form.getDevId();
    }

    public void setDevId(String devId) {
        form.setDevId(devId);
    }

    public String getDevType() {
        return form.getDevType();
    }

    public void setDevType(String devType) {
        form.setDevType(devType);
    }

    public String getDate() {
        return form.getDateString();
    }

    public void setDate(String date) {
        form.setDateString(date);
    }

    public Double getAverageIntensity() {
        return form.getAverageIntensity();
    }

    public void setAverageIntensity(Double averageIntensity) {
        if (form.getIntensities() == null) {
            Double[] intensities = {averageIntensity};
            form.setIntensities(intensities);
        }
    }

    public String getIntensities() {
        return form.getIntensitiesJSON();
    }

    public void setIntensities(String intensities) {
        form.setIntensitiesJSON(intensities);
    }

    public String getCoord() {
        return form.getCoord();
    }

    public void setCoord(String coord) {
        form.setCoord(coord);
    }

    public String getAutoAddress() {
        return form.getAutoAddress();
    }

    public void setAutoAddress(String autoAddress) {
        form.setAutoAddress(autoAddress);
    }

    public Double getAutoLatitude() {
        return form.getAutoLatitude();
    }

    public void setAutoLatitude(Double autoLatitude) {
        form.setAutoLatitude(autoLatitude);
    }

    public Double getAutoLongitude() {
        return form.getAutoLongitude();
    }

    public void setAutoLongitude(Double autoLongitude) {
        form.setAutoLongitude(autoLongitude);
    }

    public Double getAutoAltitude() {
        return form.getAutoAltitude();
    }

    public void setAutoAltitude(Double autoAltitude) {
        form.setAutoAltitude(autoAltitude);
    }

    public Double getAutoHorizontalAccuracy() {
        return form.getAutoHorizontalAccuracy();
    }

    public void setAutoHorizontalAccuracy(Double autoHorizontalAccuracy) {
        form.setAutoHorizontalAccuracy(autoHorizontalAccuracy);
    }

    public Double getAutoVerticalAccuracy() {
        return form.getAutoVerticalAccuracy();
    }

    public void setAutoVerticalAccuracy(Double autoVerticalAccuracy) {
        form.setAutoVerticalAccuracy(autoVerticalAccuracy);
    }

    public String getManualAddress() {
        return form.getManualAddress();
    }

    public void setManualAddress(String manualAddress) {
        form.setManualAddress(manualAddress);
    }

    public Double getManualLatitude() {
        return form.getManualLatitude();
    }

    public void setManualLatitude(Double manualLatitude) {
        form.setManualLatitude(manualLatitude);
    }

    public Double getManualLongitude() {
        return form.getManualLongitude();
    }

    public void setManualLongitude(Double manualLongitude) {
        form.setManualLongitude(manualLongitude);
    }

    public String getSfaType() {
        return form.getSfaType();
    }

    public void setSfaType(String sfaType) {
        form.setSfaType(sfaType);
    }

    public String getNoiseType() {
        return form.getNoiseType();
    }

    public void setNoiseType(String noiseType) {
        form.setNoiseType(noiseType);
    }

    public String getComment() {
        return form.getComment();
    }

    public void setComment(String comment) {
        form.setComment(comment);
    }
}