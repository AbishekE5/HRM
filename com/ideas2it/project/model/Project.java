/**
 * Provides the necessary information to create project model class
 * To create objects and to communicate with the Dao classes where it is stored
 */
package com.ideas2it.project.model;

/**
 * This class creates the project objects
 */
public class Project {
    private int projectId;
    private String projectName;
    private String timeEstimation;
    private String budget;
    private String description;

    /**
     * Parameterized constructor of Project object
     * @param projectId
     * @param description
     * @param timeEstimation
     * @param budget
     * @param projectName
     */
    public Project(int projectId, String description, String timeEstimation, String budget, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.timeEstimation = timeEstimation;
        this.budget = budget;
        this.description = description;
    }

    /**
     * Default Constructor
     */
    public Project() {

    }

    /**
     * This method is used to get employeeId object
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * This method is used to set projectId object
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * This method is used to get project name object
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method is used to set project name object
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * This method is used to get time estimation object
     */
    public String getTimeEstimation() {
        return timeEstimation;
    }

    /**
     * This method is used to set time estimation object
     */
    public void setTimeEstimation(String timeEstimation) {
        this.timeEstimation = timeEstimation;
    }

    /**
     * This method is used to get budget object
     */
    public String getBudget() {
        return budget;
    }

    /**
     * This method is used to set budget object
     */
    public void setBudget(String budget) {
        this.budget = budget;
    }

    /**
     * This method is used to get description object
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method is used to set description object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method is used o append all the objects o list
     */
    public String toString() {
        return "PROJECT [PROJECTID= " + projectId + ", DESCRIPTION= " + description + ", PROJECTNAME = " + projectName + ", TIME " + timeEstimation + ", BUDGET " + budget + "]";
    }
}
