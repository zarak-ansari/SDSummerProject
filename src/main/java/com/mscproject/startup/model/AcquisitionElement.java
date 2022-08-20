package com.mscproject.startup.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AcquisitionElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private int startingValue;
    private int incrementEachPeriod;
    private int startingPeriod;
    private int endingPeriod;
    private float costPerAcquisition;


}
