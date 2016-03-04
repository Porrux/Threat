package com.porrux.threat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import javax.annotation.Generated;

/**
 * Created by tperroin on 04/03/2016.
 */
@Generated("org.jsonschema2pojo")
public class Event {
    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("effectArea")
    @Expose
    private Integer effectArea;

    @SerializedName("level")
    @Expose
    private Integer level;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("rating")
    @Expose
    private Integer rating;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("type")
    @Expose
    private Type type;

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    @SerializedName("uuid")
    @Expose
    private String uuid;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getEffectArea() {
        return effectArea;
    }

    public void setEffectArea(Integer effectArea) {
        this.effectArea = effectArea;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
