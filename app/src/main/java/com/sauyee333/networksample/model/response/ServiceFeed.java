package com.sauyee333.networksample.model.response;

/**
 * Created by sauyee on 20/9/16.
 */
public class ServiceFeed {
    private ResponseData responseData;

    private String responseDetails;

    private String responseStatus;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        return "ClassPojo [responseData = " + responseData + ", responseDetails = " + responseDetails + ", responseStatus = " + responseStatus + "]";
    }
}