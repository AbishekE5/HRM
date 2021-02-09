/**
 * Provides the necessary information to create project controller class
 * To communicate with project service and project Dao classes
 */
package com.ideas2it.project.controller;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.project.model.Project;

import com.ideas2it.project.service.Impl.ProjectServiceImpl;

public class ProjectController {

    /**
     * This method is used to create employee details.
     * @param projectId This is the first parameter to create Employee
     * @param projectName  This is the second parameter to create Employee
     * @param timeEstimation  This is the third parameter to createEmployee
     * @param budget This is the fourth parameter to createEmployee
     * @param description  This is the fifth parameter to createEmployee
     * @return projectId, projectName, timeEstimation, bugdet, description
     */
    ProjectServiceImpl projectService = new ProjectServiceImpl();

    public Project insertProject(String projectName, String timeEstimation, String budget, String description) throws SQLException {
        return projectService.insertProject(projectName, timeEstimation, budget, description);
    }

    /**
     * This method is used to send the user input to retrieve employee details.
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

    /**
     * This method is used to get  employee details.
     * @param projectId
     * @return
     * @throws SQLException
     */
    public Project getProjectById(int projectId) throws SQLException {
        return projectService.getProjectById(projectId);
    }

    /**
     * This method is used to view all project details.
     * @param project
     * @return
     * @throws SQLException
     */
    public List<Project> viewAllProject(List<Project> project) throws SQLException {
        return projectService.viewAllProject(project);
    }
}
