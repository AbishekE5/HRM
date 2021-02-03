/**
 * Provides the necessary information to create Project Dao Implementation class
 * To communicate with the sql server database and to convert the project object to table
 */

package com.ideas2it.project.dao.DaoImpl;

import java.sql.SQLException;

import com.ideas2it.project.model.Project;

/**
 * This interface method implements Employee
 */
public interface ProjectDao {

    /**
     * This method is used to create employee details in the employee table
     */
    public Project addProjectbyId(Project project);

    /**
     * This method is used to update employee details in the employee table
     */
    public int updateProjectById(int update, String phoneNumber, String emailID, String firstName, String lastName);

    /**
     * This method is used to delete employee details in the employee table
     */
    public int deleteProjectById(int projectId) throws SQLException;

    /**
     * This method is used to retrive employee details in the employee table
     */
    public int getProjectById(int projectId) throws SQLException;
}
