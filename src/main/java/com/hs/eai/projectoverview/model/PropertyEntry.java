package com.hs.eai.projectoverview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="propertyentry")
public class PropertyEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;
	@Column(name="ENTITY_NAME",columnDefinition="nvarchar")
    private String entityName;
	@Column(name="ENTITY_ID",columnDefinition="numeric")
    private Integer entityId;
	@Column(name="PROPERTY_KEY",columnDefinition="nvarchar")
    private String propertyKey;
	@Column(name="propertytype",columnDefinition="int")
    private int propertyType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public String getPropertyKey() {
		return propertyKey;
	}
	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}
	public int getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

}
