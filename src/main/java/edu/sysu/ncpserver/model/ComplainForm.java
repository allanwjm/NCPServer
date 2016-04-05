package edu.sysu.ncpserver.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.sysu.ncpserver.utils.Config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mura on 3/28/16
 */
@SuppressWarnings("unused")
public class ComplainForm {

    ////////////////////////////////////////////////////////////////////////////////
    // Fields
    ////////////////////////////////////////////////////////////////////////////////
    // Form information
    private Long formId;
    private String devId;
    private String devType;
    private Date date = new Date();

    // Intensity
    private Double[] intensities = {};

    // Location
    private String coord;
    private String autoAddress;
    private Double autoLatitude;
    private Double autoLongitude;
    private Double autoAltitude;
    private Double autoHorizontalAccuracy;
    private Double autoVerticalAccuracy;

    private String manualAddress;
    private Double manualLatitude;
    private Double manualLongitude;

    // Desctiption
    private String sfaType;
    private String noiseType;
    private String comment;

    ////////////////////////////////////////////////////////////////////////////////
    // Validate ComplainForm
    ////////////////////////////////////////////////////////////////////////////////
    // Check if this form contains all necessary information
    public boolean isValid() {

        // Address
        /*
        if (getAddress() == null) {
            return false;
        }
        if (getLatitude() == null || getLatitude() == 0) {
            return false;
        }
        if (getLongitude() == null || getLongitude() == 0) {
            return false;
        }*/

        // Device ID
        if (devId == null || devId.length() == 0) {
            return false;
        }

        /*
        // Intensities
        if (intensities == null || intensities.length == 0) {
            return false;
        }*/

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Calculate averageIntensity
    ////////////////////////////////////////////////////////////////////////////////
    // Return average value of the intensities array
    public Double getAverageIntensity() {
        if (intensities != null && intensities.length > 0) {
            double sum = 0;
            for (double intensity : intensities) {
                sum += intensity;
            }
            return sum / intensities.length;
        }
        return 0.0;
    }

    // Set intensity when the array is empty
    public void setAverageIntensity(Double averageIntensity) {
        if (intensities == null || intensities.length == 0) {
            intensities = new Double[]{averageIntensity};
        }
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
    // Convert intensities between 'Double[]' and JSON
    ////////////////////////////////////////////////////////////////////////////////
    // Getter
    public String getIntensitiesJSON() {
        // Convert with GSON
        Gson gson = new GsonBuilder().create();
        return gson.toJson(intensities);
    }

    // Setter
    public void setIntensitiesJSON(String json) {
        // Convert with GSON
        Gson gson = new GsonBuilder().create();
        intensities = gson.fromJson(json, Double[].class);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Default Address Getters
    ////////////////////////////////////////////////////////////////////////////////
    // Address getter
    public String getAddress() {
        if (manualAddress != null && manualAddress.length() > 0) {
            return manualAddress;
        } else if (autoAddress != null && autoAddress.length() > 0) {
            return autoAddress;
        }
        return null;
    }

    // Latitude getter
    public Double getLatitude() {
        if (manualLatitude != null && manualLatitude != 0.0) {
            return manualLatitude;
        } else if (autoLatitude != null && autoLatitude != 0.0) {
            return autoLatitude;
        }
        return null;
    }

    // Longitude getter
    public Double getLongitude() {
        if (manualLongitude != null && manualLongitude != 0.0) {
            return manualLongitude;
        } else if (autoLongitude != null && autoLongitude != 0.0) {
            return autoLongitude;
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double[] getIntensities() {
        return intensities;
    }

    public void setIntensities(Double[] intensities) {
        this.intensities = intensities;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getAutoAddress() {
        return autoAddress;
    }

    public void setAutoAddress(String autoAddress) {
        this.autoAddress = autoAddress;
    }

    public Double getAutoLatitude() {
        return autoLatitude;
    }

    public void setAutoLatitude(Double autoLatitude) {
        this.autoLatitude = autoLatitude;
    }

    public Double getAutoLongitude() {
        return autoLongitude;
    }

    public void setAutoLongitude(Double autoLongitude) {
        this.autoLongitude = autoLongitude;
    }

    public Double getAutoAltitude() {
        return autoAltitude;
    }

    public void setAutoAltitude(Double autoAltitude) {
        this.autoAltitude = autoAltitude;
    }

    public Double getAutoHorizontalAccuracy() {
        return autoHorizontalAccuracy;
    }

    public void setAutoHorizontalAccuracy(Double autoHorizontalAccuracy) {
        this.autoHorizontalAccuracy = autoHorizontalAccuracy;
    }

    public Double getAutoVerticalAccuracy() {
        return autoVerticalAccuracy;
    }

    public void setAutoVerticalAccuracy(Double autoVerticalAccuracy) {
        this.autoVerticalAccuracy = autoVerticalAccuracy;
    }

    public String getManualAddress() {
        return manualAddress;
    }

    public void setManualAddress(String manualAddress) {
        this.manualAddress = manualAddress;
    }

    public Double getManualLatitude() {
        return manualLatitude;
    }

    public void setManualLatitude(Double manualLatitude) {
        this.manualLatitude = manualLatitude;
    }

    public Double getManualLongitude() {
        return manualLongitude;
    }

    public void setManualLongitude(Double manualLongitude) {
        this.manualLongitude = manualLongitude;
    }

    public String getSfaType() {
        return sfaType;
    }

    public void setSfaType(String sfaType) {
        this.sfaType = sfaType;
    }

    public String getNoiseType() {
        return noiseType;
    }

    public void setNoiseType(String noiseType) {
        this.noiseType = noiseType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
