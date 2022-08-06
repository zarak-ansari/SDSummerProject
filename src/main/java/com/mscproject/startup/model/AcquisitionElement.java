package com.mscproject.startup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AcquisitionElement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private int startingValue;
    private int incrementEachPeriod;
    private int costPerAcquisition;

    public AcquisitionElement() {

    }

    public AcquisitionElement(Long id, String name, String description, int startingValue, int incrementEachPeriod,
            int costPerAcquisition) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startingValue = startingValue;
        this.incrementEachPeriod = incrementEachPeriod;
        this.costPerAcquisition = costPerAcquisition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartingValue() {
        return startingValue;
    }

    public void setStartingValue(int startingValue) {
        this.startingValue = startingValue;
    }

    public int getIncrementEachPeriod() {
        return incrementEachPeriod;
    }

    public void setIncrementEachPeriod(int incrementEachPeriod) {
        this.incrementEachPeriod = incrementEachPeriod;
    }

    public int getCostPerAcquisition() {
        return costPerAcquisition;
    }

    public void setCostPerAcquisition(int costPerAcquisition) {
        this.costPerAcquisition = costPerAcquisition;
    }

}
