package com.hs.eai.projectoverview.model;

import java.util.List;


public class ProjectDetails {

	private Project project;
	private String  projectCategory;
	private Integer totalIssues;
	private Integer openIssues;
	private Integer reopenIssues;
	private Integer resolvedIssues;
	private Integer closedIssues;
	private Integer completedIssues;
	private Integer inprogressIssues;
	private String  progress ;
	private List<String> assignees;
	private List<JiraAction> activities;

	
	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}



	public Integer getTotalIssues() {
		return totalIssues;
	}



	public void setTotalIssues(Integer totalIssues) {
		this.totalIssues = totalIssues;
	}



	public Integer getOpenIssues() {
		return openIssues;
	}



	public void setOpenIssues(Integer openIssues) {
		this.openIssues = openIssues;
	}



	public Integer getReopenIssues() {
		return reopenIssues;
	}



	public void setReopenIssues(Integer reopenIssues) {
		this.reopenIssues = reopenIssues;
	}



	public Integer getResolvedIssues() {
		return resolvedIssues;
	}



	public void setResolvedIssues(Integer resolvedIssues) {
		this.resolvedIssues = resolvedIssues;
	}



	public Integer getClosedIssues() {
		return closedIssues;
	}



	public void setClosedIssues(Integer closedIssues) {
		this.closedIssues = closedIssues;
	}



	public Integer getCompletedIssues() {
		return completedIssues;
	}



	public void setCompletedIssues(Integer completedIssues) {
		this.completedIssues = completedIssues;
	}



	public Integer getInprogressIssues() {
		return inprogressIssues;
	}



	public void setInprogressIssues(Integer inprogressIssues) {
		this.inprogressIssues = inprogressIssues;
	}



	public String getProgress() {
		return progress;
	}



	public void setProgress(String progress) {
		this.progress = progress;
	}



	public List<String> getAssignees() {
		return assignees;
	}



	public void setAssignees(List<String> assignees) {
		this.assignees = assignees;
	}



	public List<JiraAction> getActivities() {
		return activities;
	}



	public void setActivities(List<JiraAction> activities) {
		this.activities = activities;
	}

	public String getProjectCategory() {
		return projectCategory;
	}



	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}




	@Override
	public String toString() {
		return "ProjectDetails [project=" + project + ", totalIssues=" + totalIssues + ", completedIssues="
				+ completedIssues + ", inprogressIssues=" + inprogressIssues + ", openIssues=" + openIssues
				+ ", progress=" + progress + ", assignees=" + assignees + ", activities=" + activities + "]";
	}
	
}
