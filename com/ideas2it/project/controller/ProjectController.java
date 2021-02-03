/**
 * Provides the necessary information to create project controller class
 * To communicate with project service and project Dao classes
 */

package com.ideas2it.project.controller;

import java.sql.SQLException;

import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.ProjectService;

public class ProjectController {

    /**
     * This method is used to create employee details.
     *
     * @param projectId This is the first parameter to create Employee
     * @param projectName  This is the second parameter to create Employee
     * @param timeEstimation  This is the third parameter to createEmployee
     * @param budget This is the fourth parameter to createEmployee
     * @param description  This is the fifth parameter to createEmployee
     * @return projectId, projectName, timeEstimation, bugdet, description
     */
    ProjectService projectService = new ProjectService();

    public Project createProject(int projectId, String projectName, String timeEstimation, String bugdet, String description) throws SQLException {
        return projectService.getProject(projectId, projectName, timeEstimation, bugdet, description);
    }

    /**
     * This method is used to send the user input to retrive employee details.
     *
     * @param projectId,projectName,timeEstimation,bugdet,description
     * @return projectId, projectName, timeEstimation, bugdet, description
     */
    public int updateProject(int projectId, String projectName, String timeEstimation, String bugdet, String description) throws SQLException {
        return projectService.updateProject(projectId, projectName, timeEstimation, bugdet, description);
    }

    /**
     * This method is used to send the user input to delete employee details.
     *
     * @param projectId This is the  parameter to delete Employee
     * @return delete
     */
    public int deleteProject(int projectId) throws SQLException {
        return projectService.deleteProject(projectId);
    }
}
