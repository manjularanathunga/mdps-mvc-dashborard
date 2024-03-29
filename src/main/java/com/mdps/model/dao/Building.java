package com.mdps.model.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_BUILDING", schema = "dskdb_v1")
@SequenceGenerator(name = "seq", initialValue = 1, schema = "dskdb_v1", sequenceName = "seq_screen", catalog = "dskdb_v1")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID", unique = true)
    private Long id;
    private Long buildingNumber;
    private String name;
    private Long noOfRooms;
    private String ownedBy;
    private Date dateCreated;
    private Date dateModified;
    private String remarks;
    private Long status;

    public Building() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Long buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Long noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", buildingNumber=" + buildingNumber +
                ", name='" + name + '\'' +
                ", noOfRooms=" + noOfRooms +
                ", ownedBy='" + ownedBy + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                '}';
    }
}
