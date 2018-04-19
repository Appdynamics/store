package com.amazon.aws.samplecode.travellog.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
    Bogus data to simulate large table
   
 */
@Entity(name="ZIPCODES")
@XmlRootElement(name = "itinerary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Itinerary {
    @Id
    private Long recordNumber;
    private String zipCode;
    private String city;
    private String state;
    private String zipCodeType;
    private String totalWages;
    private String notes;
    private String decommisioned;
    private String worldRegion;
    private double lat;
    private double longitude;
    private double xAxis;
    private double yAxis;
    private double zAxis;


    public Long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(Long recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCodeType() {
        return zipCodeType;
    }

    public void setZipCodeType(String zipCodeType) {
        this.zipCodeType = zipCodeType;
    }

    public String getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(String totalWages) {
        this.totalWages = totalWages;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDecommisioned() {
        return decommisioned;
    }

    public void setDecommisioned(String decommisioned) {
        this.decommisioned = decommisioned;
    }

    public String getWorldRegion() {
        return worldRegion;
    }

    public void setWorldRegion(String worldRegion) {
        this.worldRegion = worldRegion;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    public double getzAxis() {
        return zAxis;
    }

    public void setzAxis(double zAxis) {
        this.zAxis = zAxis;
    }
}
