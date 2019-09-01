package com.mdps.model.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_OFFICEROOM", schema = "dskdb_v1")
@SequenceGenerator(name = "seq", initialValue = 1, schema = "dskdb_v1", sequenceName = "seq_screen", catalog = "dskdb_v1")
public class OfficeRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID", unique = true)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;
    private Long roomNumber;
    private Long noOfPeopleUsedBy;
    private String remarks;
    private Date dateCreated;
    private Date dateModified;
    private Long status;

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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Long getNoOfPeopleUsedBy() {
        return noOfPeopleUsedBy;
    }

    public void setNoOfPeopleUsedBy(Long noOfPeopleUsedBy) {
        this.noOfPeopleUsedBy = noOfPeopleUsedBy;
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

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
}
