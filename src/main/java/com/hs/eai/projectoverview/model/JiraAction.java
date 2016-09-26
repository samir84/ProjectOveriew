package com.hs.eai.projectoverview.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the Jiraaction database table.
 * 
 */
@Entity
@Table(name = "jiraaction")
@NamedQueries({
	@NamedQuery(name = "jiraaction.findAll", query = "SELECT j FROM JiraAction j"),
	@NamedQuery(name = "jiraaction.findByProjectId", query = "FROM JiraAction ja where ja.issueid in ( select j.id from JiraIssue j where j.project=:id ) order by ja.CREATED desc")
})


public class JiraAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",columnDefinition="numeric")
	private Integer id;
	@Column(name="issueid",columnDefinition="numeric")
	private Integer issueid;
	
	@Column(columnDefinition="nvarchar")
	private String AUTHOR;
	@Column(columnDefinition="nvarchar")
	private String actiontype;
	@Column(columnDefinition="nvarchar")
	private String actionlevel;
	@Column(columnDefinition="numeric")
	private String rolelevel;
	@Column(columnDefinition="ntext")
	private String actionbody;
	private Timestamp CREATED;
	@Column(columnDefinition="nvarchar")
	private String UPDATEAUTHOR;
	private Timestamp UPDATED;
	@Column(columnDefinition="numeric")
	private String actionnum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIssueid() {
		return issueid;
	}
	public void setIssueid(Integer issueid) {
		this.issueid = issueid;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}
	public String getActiontype() {
		return actiontype;
	}
	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}
	public String getActionlevel() {
		return actionlevel;
	}
	public void setActionlevel(String actionlevel) {
		this.actionlevel = actionlevel;
	}
	public String getRolelevel() {
		return rolelevel;
	}
	public void setRolelevel(String rolelevel) {
		this.rolelevel = rolelevel;
	}
	public String getActionbody() {
		return actionbody;
	}
	public void setActionbody(String actionbody) {
		this.actionbody = actionbody;
	}
	public Timestamp getCREATED() {
		return CREATED;
	}
	public void setCREATED(Timestamp cREATED) {
		CREATED = cREATED;
	}
	public String getUPDATEAUTHOR() {
		return UPDATEAUTHOR;
	}
	public void setUPDATEAUTHOR(String uPDATEAUTHOR) {
		UPDATEAUTHOR = uPDATEAUTHOR;
	}
	public Timestamp getUPDATED() {
		return UPDATED;
	}
	public void setUPDATED(Timestamp uPDATED) {
		UPDATED = uPDATED;
	}
	public String getActionnum() {
		return actionnum;
	}
	public void setActionnum(String actionnum) {
		this.actionnum = actionnum;
	}
	
	
	@Override
	public String toString() {
		return "JiraAction [id=" + id + ", issueid=" + issueid + ", AUTHOR=" + AUTHOR + ", actiontype=" + actiontype
				+ ", actionlevel=" + actionlevel + ", rolelevel=" + rolelevel + ", actionbody=" + actionbody
				+ ", CREATED=" + CREATED + ", UPDATEAUTHOR=" + UPDATEAUTHOR + ", UPDATED=" + UPDATED + ", actionnum="
				+ actionnum + "]";
	}
	
}