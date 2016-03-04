package com.porrux.threat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.Generated;

/**
 * Created by tperroin on 04/03/2016.
 */
@Generated("org.jsonschema2pojo")
public class Type implements Serializable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("uuid")
    @Expose
    private UUID uuid;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
