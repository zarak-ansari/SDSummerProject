package com.mscproject.startup.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private float percentageOfReferringUsers;
    private int referralsPerUser;
    private float costPerReferral;

}
