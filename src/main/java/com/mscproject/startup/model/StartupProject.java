package com.mscproject.startup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    @ManyToOne
    private AppUser user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AcquisitionElement> acquisitionElements = new ArrayList<>();

    // private List<ActivationElement> activationElements;
    // private List<RetentionCurve> retentionCurve;
    // private List<Referral> Referral;

}
