package edu.sysu.ncpserver.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by mura on 4/1/16
 */
public class HeatMapPoint {

    private Double lng;
    private Double lat;
    private Double count;

    ////////////////////////////////////////////////////////////////////////////////
    // Constructor from ComplainForm
    ////////////////////////////////////////////////////////////////////////////////
    public HeatMapPoint(ComplainForm form) {
        lat = form.getLatitude();
        lng = form.getLongitude();
        count = form.getAverageIntensity();
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////
    public Double getLat() {
        return lat;
    }

    public void setLat(Double latitude) {
        this.lat = latitude;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double longitude) {
        this.lng = longitude;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
