package com.mdps.model.dao;

import javax.persistence.*;
import java.util.Date;
/*
Created by : Sirimewan M Ranathunga
Created Date : 2019/07/01
*/

@Entity
@Table(name = "TBL_USER")
public class MUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userId;
    private String password;
    private Long userTypeId;
    private Date dateCreated;
    private Date dateModified;
    private boolean status;

    public MUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userTypeId=" + userTypeId +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", status=" + status +
                '}';
    }
}
