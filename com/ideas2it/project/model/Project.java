package com.ideas2it.project.model;

public class Project {
    private Integer projectId;
    private String projectName;
    private String timeEstimation;
    private String budget;
    private String description;


    public Project(Integer projectId, String description, String timeEstimation, String budget, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.timeEstimation = timeEstimation;
        this.budget = budget;
        this.description = description;
    }

    public Project() {

    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(String timeEstimation) {
        this.timeEstimation = timeEstimation;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return "PROJECT [PROJECTID= " + projectId + ", DESCRIPTION= " + description + ", PROJECTNAME = " + projectName + ", TIME " + timeEstimation + ", BUDGET " + budget + "]";
    }
}
