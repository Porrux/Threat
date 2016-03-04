package com.porrux.threat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

/**
 * Created by tperroin on 04/03/2016.
 */
@Generated("org.jsonschema2pojo")
public class Location implements Serializable {

    @SerializedName("x")
    @Expose
    private Double x;

    @SerializedName("y")
    @Expose
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
