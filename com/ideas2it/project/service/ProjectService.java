/**
 * Provides the necessary information to create Project Service Interface
 * To communicate with the sql server database and to convert the employee object to table
 */
package com.ideas2it.project.service;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * Interface method implementing Project Service
 */
public interface ProjectService {

    /**
     * This interface method is used to insert project details in project table
     * @param projectName
     * @param timeEstimation
     * @param budget
     * @param description
     * @return
     */
    public Project insertProject(String projectName, String timeEstimation, String budget, String description);

    /**
     * This interface method is used to delete project details in the project table
     * @param projectId
     * @return projectId
     * @throws SQLException
     */
    public int deleteProject(int projectId) throws SQLException;

    /**
     * This interface method is used to update project details in the project table
     * @param projectId, projectName, timeEstimation, budget, description
     * @return projectId, projectName, timeEstimation, budget, description
     * @throws SQLException
     */
    public int updateProject(int projectId, String projectName, String timeEstimation, String budget, String description);

    /**
     * This interface method is used to retrieve project details in the project table
     * @param projectId
     * @return
     */
    public Project getProjectById(int projectId) throws SQLException;

    /**
     *  This interface method is used to view-all project details in the project table
     * @param project
     * @return project
     * @throws SQLException
     */
    List<Project> viewProject(List<Project> project) throws SQLException;
}