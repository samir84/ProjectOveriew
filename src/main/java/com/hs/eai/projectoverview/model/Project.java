package com.hs.eai.projectoverview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
@NamedQueries({
	@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
	@NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p where p.id=:id"),
	@NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p where p.pname=:pname"),
	@NamedQuery(name = "Project.findByKey", query = "SELECT p FROM Project p where p.pkey=:pkey"),
	@NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p where p.description=:description"),
	@NamedQuery(name = "Project.findProjectsByAssignee", query = "SELECT p FROM Project p where p.id in ( select j.project from JiraIssue j where j.assignee=:assignee )"),
	@NamedQuery(name = "Project.findLazyLoadProjects", query = "SELECT p FROM Project p ")
	
	
})
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;

	@Column(name="ASSIGNEETYPE",columnDefinition="numeric")
	private Integer assigneetype;

	@Column(name="AVATAR",columnDefinition="numeric")
	private Integer avatar;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="LEAD")
	private String lead;

	@Column(name="ORIGINALKEY")
	private String originalkey;

	@Column(columnDefinition="numeric")
	private Integer pcounter;
	private String pkey;
	private String pname;

	@Column(name="PROJECTTYPE")
	private String projecttype;

	@Column(name="URL")
	private String url;

	public Project() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAssigneetype() {
		return this.assigneetype;
	}

	public void setAssigneetype(Integer assigneetype) {
		this.assigneetype = assigneetype;
	}

	public Integer getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Integer avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLead() {
		return this.lead;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public String getOriginalkey() {
		return this.originalkey;
	}

	public void setOriginalkey(String originalkey) {
		this.originalkey = originalkey;
	}

	public Integer getPcounter() {
		return this.pcounter;
	}

	public void setPcounter(Integer pcounter) {
		this.pcounter = pcounter;
	}

	public String getPkey() {
		return this.pkey;
	}

	public void setPkey(String pkey) {
		this.pkey = pkey;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getProjecttype() {
		return this.projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", assigneetype=" + assigneetype + ", avatar=" + avatar + ", description="
				+ description + ", lead=" + lead + ", originalkey=" + originalkey + ", pcounter=" + pcounter + ", pkey="
				+ pkey + ", pname=" + pname + ", projecttype=" + projecttype + ", url=" + url + "]";
	}


}