package com.daluga.feature.metrics.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FeatureMetric {

    private long id;
    private String username;
    private long businessSystemId;
    private String featureName;
    private String dealerNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(long businessSystemId) {
        this.businessSystemId = businessSystemId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getDealerNumber() {
        return dealerNumber;
    }

    public void setDealerNumber(String dealerNumber) {
        this.dealerNumber = dealerNumber;
    }

    public String toString() {
        return new ToStringBuilder(this).
                append("id", id).
                append("username", username).
                append("businessSystemId", businessSystemId).
                append("featureName", featureName).
                append("dealerNumber", dealerNumber).
                toString();
    }
}
