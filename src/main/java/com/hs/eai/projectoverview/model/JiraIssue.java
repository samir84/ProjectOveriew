package com.hs.eai.projectoverview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the jiraissue database table.
 * 
 */
@Entity
@Table(name="jiraissue")
@NamedQueries({
	@NamedQuery(name = "Jiraissue.findAll", query = "SELECT j FROM JiraIssue j"),
	@NamedQuery(name = "Jiraissue.findTotalIssuesByProjectId", query = "select count(*) FROM JiraIssue j where j.project=:id"),
	@NamedQuery(name = "Jiraissue.findTotalIssuesByProjectAndStatus", query = "select count(*) FROM JiraIssue j where j.issuestatus=:issuestatus and j.project=:id"),
	@NamedQuery(name = "Jiraissue.findTotalIssuesByProjectAndStatussen", query = "select count(*) FROM JiraIssue j where j.issuestatus in(:ids) and j.project=:id"),
	@NamedQuery(name = "Jiraissue.findAssigneesByProject", query = "select distinct j.assignee FROM JiraIssue j where j.project=:id"),
	@NamedQuery(name = "Jiraissue.findTimeoriginalestimateByProjectAndCreatetdBetween", query = "select j.timeoriginalestimate FROM JiraIssue j where j.project=:id "
			+ "																					and ( j.created>=:fromDateCreated and j.created<:toDateCreated)"),
	@NamedQuery(name = "Jiraissue.findTimespentByProjectAndCreatetdBetween", query = "select j.timespent FROM JiraIssue j where j.project=:id "
			+ "																					and ( j.created>=:fromDateCreated and j.created<:toDateCreated)")
})
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callUspSelectLast12MonthsTimeOrgEstimatedVsTimeSpent",
	query = "CALL dbo.uspSelectLast12MonthsTimeOrgEstimatedVsTimeSpent(:yearCreated,:projectId)"
	
	)
})
public class JiraIssue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",columnDefinition="numeric")
	private long id;
	
	@Column(name="pkey",columnDefinition="nvarchar")
	private String pkey;
	
	@Column(name="issuenum",columnDefinition="numeric")
	private Integer issuenum;
	
	@Column(name="PROJECT",columnDefinition="numeric")
	private Integer project;
	
	@Column(name="REPORTER" , columnDefinition="nvarchar")
	private String reporter;
	
	@Column(name="ASSIGNEE" , columnDefinition="nvarchar")
	private String assignee;

	@Column(name="COMPONENT",columnDefinition="numeric")
	private Integer component;

	@Column(name="CREATED")
	private Timestamp created;

	@Column(name="CREATOR" , columnDefinition="nvarchar")
	private String creator;

	@Column(name="DESCRIPTION",columnDefinition="ntext")
	private String description;

	@Column(name="DUEDATE")
	private Timestamp duedate;

	@Column(name="ENVIRONMENT",columnDefinition="ntext")
	private String environment;

	@Column(name="FIXFOR",columnDefinition="numeric")
	private Integer fixfor;
	@Column(columnDefinition="nvarchar")
	private Long issuestatus;
	
	@Column(columnDefinition="nvarchar")
	private String issuetype;

	@Column(name="PRIORITY",columnDefinition="nvarchar")
	private String priority;

	@Column(name="RESOLUTION",columnDefinition="nvarchar")
	private String resolution;

	@Column(name="RESOLUTIONDATE")
	private Timestamp resolutiondate;

	@Column(name="SECURITY",columnDefinition="numeric")
	private Integer security;

	@Column(columnDefinition="nvarchar")
	private String summary;

	@Column(name="TIMEESTIMATE",columnDefinition="numeric")
	private Integer timeestimate;

	@Column(name="TIMEORIGINALESTIMATE",columnDefinition="numeric")
	private Integer timeoriginalestimate;

	@Column(name="TIMESPENT",columnDefinition="numeric")
	private Integer timespent;

	@Column(name="UPDATED")
	private Timestamp updated;

	@Column(name="VOTES",columnDefinition="numeric")
	private Integer votes;

	@Column(name="WATCHES",columnDefinition="numeric")
	private Integer watches;

	@Column(name="WORKFLOW_ID",columnDefinition="numeric")
	private Integer workflowId;

	public JiraIssue() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Integer getComponent() {
		return this.component;
	}

	public void setComponent(Integer component) {
		this.component = component;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Integer getFixfor() {
		return this.fixfor;
	}

	public void setFixfor(Integer fixfor) {
		this.fixfor = fixfor;
	}

	public Integer getIssuenum() {
		return this.issuenum;
	}

	public void setIssuenum(Integer issuenum) {
		this.issuenum = issuenum;
	}

	public Long getIssuestatus() {
		return this.issuestatus;
	}

	public void setIssuestatus(Long issuestatus) {
		this.issuestatus = issuestatus;
	}

	public String getIssuetype() {
		return this.issuetype;
	}

	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
	}

	public String getPkey() {
		return this.pkey;
	}

	public void setPkey(String pkey) {
		this.pkey = pkey;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getProject() {
		return this.project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public String getReporter() {
		return this.reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Timestamp getResolutiondate() {
		return this.resolutiondate;
	}

	public void setResolutiondate(Timestamp resolutiondate) {
		this.resolutiondate = resolutiondate;
	}

	public Integer getSecurity() {
		return this.security;
	}

	public void setSecurity(Integer security) {
		this.security = security;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getTimeestimate() {
		return this.timeestimate;
	}

	public void setTimeestimate(Integer timeestimate) {
		this.timeestimate = timeestimate;
	}

	public Integer getTimeoriginalestimate() {
		return this.timeoriginalestimate;
	}

	public void setTimeoriginalestimate(Integer timeoriginalestimate) {
		this.timeoriginalestimate = timeoriginalestimate;
	}

	public Integer getTimespent() {
		return this.timespent;
	}

	public void setTimespent(Integer timespent) {
		this.timespent = timespent;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Integer getVotes() {
		return this.votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getWatches() {
		return this.watches;
	}

	public void setWatches(Integer watches) {
		this.watches = watches;
	}

	public Integer getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

}