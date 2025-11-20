package com.boni.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "table_catagory")
public class table_catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "catagory_name")
    @JsonProperty("catagory_name")
    private String catagoryName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    @JsonProperty("is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_by")
    @JsonProperty("created_by")
    private Integer createdBy;

    @Column(name = "created_on")
    @JsonProperty("created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    @JsonProperty("updated_by")
    private Integer updatedBy;

    @Column(name = "updated_on")
    @JsonProperty("updated_on")
    private Date updatedOn;

    // ---------------------------------------------------
    // Constructors
    // ---------------------------------------------------

    public table_catagory() {}

    public table_catagory(Integer id, String catagoryName, String description, Boolean isActive,
                         Boolean isDeleted, Integer createdBy, Date createdOn,
                         Integer updatedBy, Date updatedOn) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.description = description;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }

    // ---------------------------------------------------
    // Getters and Setters
    // ---------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    // ---------------------------------------------------
    // toString()
    // ---------------------------------------------------

    @Override
    public String toString() {
        return "TableCatagory{" +
                "id=" + id +
                ", catagoryName='" + catagoryName + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
