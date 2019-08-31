package com.mdps.model.dao;

import com.mdps.model.enums.InventoryStatus;

import javax.persistence.*;

/*
Created by : Sirimewan M Ranathunga
Created Date : 2019/07/01
*/

@Entity
@Table(name = "TBL_INVENTORY", schema = "dskdb_v1")
@SequenceGenerator(name = "seq", initialValue = 1, schema = "dskdb_v1", sequenceName = "seq_screen", catalog = "dskdb_v1")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID", unique = true)
    private Long id;
    private String itemNumber;
    private String itemName;
    private Long serialNumber;
    private String remarks;
    //private InventoryStatus invStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

/*    public InventoryStatus getInvStatus() {
        return invStatus;
    }

    public void setInvStatus(InventoryStatus invStatus) {
        this.invStatus = invStatus;
    }*/

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", itemNumber='" + itemNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", serialNumber=" + serialNumber +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
