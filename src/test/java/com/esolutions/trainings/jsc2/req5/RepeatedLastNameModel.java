package com.esolutions.trainings.jsc2.req5;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RepeatedLastNameModel {
    @JsonProperty("lastNames")
    private List<String> lastNames;

    public List<String> getLastNames() {
        return lastNames;
    }

    public void setLastNames(List<String> lastNames) {
        this.lastNames = lastNames;
    }
}
