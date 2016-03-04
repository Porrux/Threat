package com.porrux.threat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

/**
 * Created by tperroin on 04/03/2016.
 */
@Generated("org.jsonschema2pojo")
public class Event {
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("location")
    @Expose
    private List<Location> location = new ArrayList<Location>();
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("effectArea")
    @Expose
    private Integer effectArea;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("uuid")
    @Expose
    private UUID uuid;
    @SerializedName("rating")
    @Expose
    private Integer rating;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
