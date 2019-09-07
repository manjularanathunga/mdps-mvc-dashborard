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
    //private Long buildingId;
    private String buildingName;
    private Long roomNumber;
    private Long noOfPeopleUsedBy;
    private String remarks;
    private Date dateCreated;
    private Date dateModified;
    private Long status;

    public OfficeRoom() {
    }

    public OfficeRoom(String name, String buildingName, Long roomNumber, Long noOfPeopleUsedBy, String remarks, Date dateCreated, Date dateModified, Long status) {
        this.name = name;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.noOfPeopleUsedBy = noOfPeopleUsedBy;
        this.remarks = remarks;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;


    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

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

/*    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }*/

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OfficeRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", roomNumber=" + roomNumber +
                ", noOfPeopleUsedBy=" + noOfPeopleUsedBy +
                ", remarks='" + remarks + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", status=" + status +
                ", building=" + building +
                '}';
    }
}
