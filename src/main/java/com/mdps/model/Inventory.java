package com.mdps.model;

import javax.persistence.*;

/*
Created by : Sirimewan M Ranathunga
Created Date : 2019/07/01
*/
@Entity
@Table(name = "TBL_INVENTORY")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


}
