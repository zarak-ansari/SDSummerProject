package com.mscproject.startup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartupProject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private int numberOfPeriods;

    @ManyToOne
    private AppUser user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AcquisitionElement> acquisitionElements = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ActivationElement> activationElements;

    @ElementCollection
    private List<Float> retentionCurve;
    @OneToOne(cascade = CascadeType.ALL)
    private Referral referrals;
    @OneToOne(cascade = CascadeType.ALL)
    private Monetization monetization;

}
