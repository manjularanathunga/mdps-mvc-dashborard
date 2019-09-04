package com.mdps.model.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_CATEGORY", schema = "dskdb_v1")
@SequenceGenerator(name = "seq", initialValue = 1, schema = "dskdb_v1", sequenceName = "seq_screen", catalog = "dskdb_v1")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID", unique = true)
    private Long id;
    private String name;
    private String assetSubCode;
    private String remarks;
    private String actionBy;
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

    public String getAssetSubCode() {
        return assetSubCode;
    }

    public void setAssetSubCode(String assetSubCode) {
        this.assetSubCode = assetSubCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
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
}
