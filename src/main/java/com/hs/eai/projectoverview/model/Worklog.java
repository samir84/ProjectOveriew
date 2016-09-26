package com.hs.eai.projectoverview.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


/**
 * The persistent class for the worklog database table.
 * 
 */
@Entity
@Table(name="worklog")
@NamedQueries({
	@NamedQuery(name="Worklog.findAll", query="SELECT w FROM Worklog w"),
	@NamedQuery(name="Worklog.findByAuthor", query="SELECT w FROM Worklog w where w.author=:author order by id desc"),
	@NamedQuery(name="Worklog.findByCreatedDate", query="SELECT w FROM Worklog w where w.created=:created order by id desc"),
	@NamedQuery(name="Worklog.findByAuthorAndFromDateToDate", query="SELECT w FROM Worklog w where w.author=:author and ( created>=:fromDate and created<=:toDate ) order by id desc"),
	@NamedQuery(name="Worklog.findByFromDateToDate", query="SELECT w FROM Worklog w where created>=:fromDate and created<=:toDate order by id desc"),
	@NamedQuery(name="CreateWorklogDtoByAuthor", query=" select  wl.author,wl.issueid,j.project, ps.propertyValue ,wl.updated,wl.timeworked, wl.worklogbody "+
			  "from PropertyEntry pe, PropertyString ps, Worklog wl,JiraIssue j "+
			    " where "+
				" wl.author =:author and wl.issueid = j.id "+
			    " and wl.id = pe.entityId"+
			    " and pe.entityName = 'Tempo.Worklog'"+
			    " and pe.propertyKey = 'Tempo.WorklogAttributes'"+
			    " and pe.id = ps.id"+
			   " order by wl.updated desc"),

	@NamedQuery(name="CreateWorklogDtoByAuthorAndDateBetween", query=" select  wl.author,wl.issueid,j.project, ps.propertyValue ,wl.updated,wl.timeworked, wl.worklogbody "+
  "from PropertyEntry pe, PropertyString ps, Worklog wl,JiraIssue j "+
    " where "+
    " wl.created >:dateFrom and wl.updated<:dateTo"+
	" and wl.author =:author and wl.issueid = j.id "+
    " and wl.id = pe.entityId"+
    " and pe.entityName = 'Tempo.Worklog'"+
    " and pe.propertyKey = 'Tempo.WorklogAttributes'"+
    " and pe.id = ps.id"+
   " order by wl.updated desc")
})

public class Worklog implements Serializable {
	@Override
	public String toString() {
		return "Worklog [id=" + id + ", author=" + author + ", created=" + created + ", grouplevel=" + grouplevel
				+ ", issueid=" + issueid + ", rolelevel=" + rolelevel + ", startdate=" + startdate + ", timeworked="
				+ timeworked + ", updateauthor=" + updateauthor + ", updated=" + updated + ", worklogbody="
				+ worklogbody + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",columnDefinition="numeric")
	private long id;

	@Column(name="AUTHOR")
	private String author;

	@Column(name="CREATED", columnDefinition="DATETIME")
	private Date created;

	private String grouplevel;

	@Column(columnDefinition="numeric")
	private Integer issueid;
	@Column(columnDefinition="numeric")
	private Integer rolelevel;

	@Column(name="STARTDATE", columnDefinition="DATETIME")
	private Date startdate;

	@Column(columnDefinition="numeric")
	private Integer timeworked;

	@Column(name="UPDATEAUTHOR")
	private String updateauthor;

	@Column(name="UPDATED", columnDefinition="DATETIME")
	private Date updated;

	private String worklogbody;

	public Worklog() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getGrouplevel() {
		return this.grouplevel;
	}

	public void setGrouplevel(String grouplevel) {
		this.grouplevel = grouplevel;
	}

	public Integer getIssueid() {
		return this.issueid;
	}

	public void setIssueid(Integer issueid) {
		this.issueid = issueid;
	}

	public Integer getRolelevel() {
		return this.rolelevel;
	}

	public void setRolelevel(Integer rolelevel) {
		this.rolelevel = rolelevel;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Integer getTimeworked() {
		return this.timeworked;
	}

	public void setTimeworked(Integer timeworked) {
		this.timeworked = timeworked;
	}

	public String getUpdateauthor() {
		return this.updateauthor;
	}

	public void setUpdateauthor(String updateauthor) {
		this.updateauthor = updateauthor;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getWorklogbody() {
		return this.worklogbody;
	}

	public void setWorklogbody(String worklogbody) {
		this.worklogbody = worklogbody;
	}

}