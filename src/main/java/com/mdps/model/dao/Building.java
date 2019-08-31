package com.mdps.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_BUILDING", schema = "dskdb_v1")
@SequenceGenerator(name = "seq", initialValue = 1, schema = "dskdb_v1", sequenceName = "seq_screen", catalog = "dskdb_v1")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID", unique = true)
    private Long id;
    private Long buildingNumber;
    private String buildingName;
    private Long noOfRooms;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<OfficeRoom> officeRooms;
    private String ownedBy;
    private Long status;

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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public List<OfficeRoom> getOfficeRooms() {
        return officeRooms;
    }

    public void setOfficeRooms(List<OfficeRoom> officeRooms) {
        this.officeRooms = officeRooms;
    }
}
