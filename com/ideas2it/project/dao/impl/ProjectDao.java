/**
 * Provides the necessary information to create Project Dao Implementation class
 * To communicate with the sql server database and to convert the project object to table
 */
package com.ideas2it.project.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * This interface method implements Project Dao class
 */
public interface ProjectDao {

    /**
     * This method is used to create employee details in the employee table
     * @param project
     * @return
     */
    public Project insertProject(Project project);

    /**
     * This method is used to update employee details in the employee table
     * @param update
     * @param phoneNumber
     * @param emailID
     * @param firstName
     * @param lastName
     * @return
     */
    public int updateProjectById(int update, String phoneNumber, String emailID, String firstName, String lastName);

    /**
     * This method is used to delete employee details in the employee table
     * @param projectId
     * @return
     * @throws SQLException
     */
    public int deleteProjectById(int projectId) throws SQLException;

    /**
     * This method is used to retrive employee details in the employee table
     * @param projectId
     * @return
     * @throws SQLException
     */
    public Project getProjectById(int projectId) throws SQLException;

    /**
     * This method is used to view all project details in the project table
     * @param project
     * @return
     * @throws SQLException
     */
    public List<Project> viewAllProject(List<Project> project) throws SQLException;
}
