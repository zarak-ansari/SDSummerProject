package com.mscproject.startup.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Monetization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private float revenuePerUserPerPeriod;
    private float percentageOfPaidUsers;
}
