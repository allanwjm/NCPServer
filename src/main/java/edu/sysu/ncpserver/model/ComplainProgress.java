package edu.sysu.ncpserver.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.sysu.ncpserver.Config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mura on 4/11/16
 */
public class ComplainProgress {

    ////////////////////////////////////////////////////////////////////////////////
    // Fields
    ////////////////////////////////////////////////////////////////////////////////
    // ID
    private Long progressId;
    private Long formId;

    // Infomations
    private Date date = new Date();
    private Boolean finished = false;
    private String title;
    private String comment;
    private Map<String, Object> details = new TreeMap<>();

    ////////////////////////////////////////////////////////////////////////////////
    // Constructor
    ////////////////////////////////////////////////////////////////////////////////
    // Default Constructor
    public ComplainProgress() {

    }

    ////////////////////////////////////////////////////////////////////////////////
    // Attach to ComplainForm
    ////////////////////////////////////////////////////////////////////////////////
    public void attachToForm(ComplainForm form, int index) {
        progressId = (form.getFormId() % (long) Math.pow(10, 16)) * 100 + index % 100;
        this.formId = form.getFormId();
    }

    // Use FormID instead of object
    public void attachToForm(Long formId, int index) {
        progressId = (formId % (long) Math.pow(10, 16)) * 100 + index % 100;
        this.formId = formId;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Convert between JSON and Java Object
    ////////////////////////////////////////////////////////////////////////////////
    // Get JSON Map of ComplainProgress
    public Map<String, Object> getJSONMap() {
        Map<String, Object> json = new TreeMap<>();
        // Organize JSON Map manually
        json.put("progressId", progressId);
        json.put("formId", formId);
        json.put("date", getDateString());
        json.put("finished", finished ? 1 : 0);
        json.put("title", title);
        json.put("comment", comment);
        json.put("details", details);
        return json;
    }

    // Get JSON String
    public String getJsonString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(getJSONMap());
    }

    // Get JSON String of details
    public String getDetailsJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(details);
    }

    // Set details with JSON String
    @SuppressWarnings("unchecked")
    public void setDetailsJSON(String detailsJSON) {
        Gson gson = new GsonBuilder().create();
        details = gson.fromJson(detailsJSON, TreeMap.class);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Convert date between String and java.util.Date
    ////////////////////////////////////////////////////////////////////////////////
    // Getter
    public String getDateString() {
        DateFormat df = new SimpleDateFormat(Config.getString("request_dateformat"));
        return df.format(date);
    }

    // Setter
    public void setDateString(String string) {
        DateFormat df = new SimpleDateFormat(Config.getString("request_dateformat"));
        try {
            date = df.parse(string);
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Validate ComplainProgress
    ////////////////////////////////////////////////////////////////////////////////
    // Check if this progress contains all necessary information
    public boolean isValid() {
        if (title == null || title.length() == 0) {
            return false;
        }
        if (comment == null || comment.length() == 0) {
            return false;
        }
        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Details
    ////////////////////////////////////////////////////////////////////////////////
    public void addDetail(String key, Object value) {
        details.put(key, value);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
