package com.intigral.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bajpaip
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "year",
        "programType",
        "currency",
        "programAvailabilityId",
        "rating",
        "categories",
        "programDescription",
        "duration",
        "genre"
})

public class Properties {
    @JsonIgnore
    String type;
    @JsonIgnore
    String programTitle;
    @JsonIgnore
    String channelTitle;
    @JsonIgnore
    String channelNumber;
    @JsonIgnore
    String listingId;
    @JsonIgnore
    String price;
    @JsonIgnore
    String endTime;
    @JsonIgnore
    String channelId;
    @JsonIgnore
    String stationId;
    @JsonIgnore
    String startTime;
    @JsonProperty("year")
    String year;
    @JsonProperty("programType")
    String programType;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("programAvailabilityId")
    String programAvailabilityId;
    @JsonProperty("rating")
    Rating rating;
    @JsonProperty("categories")
    List<String> categories= new ArrayList<>();
    @JsonProperty("programDescription")
    ProgramDescription programDescription;
    String duration;
    @JsonProperty("genre")
    List<String> genre= new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProgramAvailabilityId() {
        return programAvailabilityId;
    }

    public void setProgramAvailabilityId(String programAvailabilityId) {
        this.programAvailabilityId = programAvailabilityId;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public ProgramDescription getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(ProgramDescription programDescription) {
        this.programDescription = programDescription;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
