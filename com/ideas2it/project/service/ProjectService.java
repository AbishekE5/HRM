/**
 * Provide the class necessary information to create service class
 * To communicate with controller and model classes
 */
package com.ideas2it.project.service;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.project.dao.ProjectDaoImpl;
import com.ideas2it.project.model.Project;

/**
 * Class performs business logic of project details
 */
public class ProjectService {
    ProjectDaoImpl projectDao = new ProjectDaoImpl();

    /**
     * This method is used to create the employee details.
     * @param projectId      This is the first parameter to create Employee
     * @param projectName    This is the second parameter to create Employee
     * @param timeEstimation This is the third parameter to createEmployee
     * @param bugdet         This is the fourth parameter to createEmployee
     * @param description    This is the fifth parameter to createEmployee
     * @return projectId, projectName, timeEstimation, budget, description
     */
    public Project getProject(int projectId, String projectName, String timeEstimation, String bugdet, String description) {
        Project project = new Project(projectId, projectName, timeEstimation, bugdet, description);
        return projectDao.addProjectbyId(project);
    }

    /**
     * This method is used to delete the employee details.
     *
     * @param projectId
     * @return projectId
     */
    public int deleteProject(int projectId) throws SQLException {
        return projectDao.deleteProjectById(projectId);
    }

    /**
     * This method is used to update the employee details.
     *
     * @param
     * @return recievedEmployee
     */
    public int updateProject(int projectId, String projectName, String timeEstimation, String bugdet, String description) {
        return projectDao.updateProjectById(projectId, description, timeEstimation, bugdet, projectName);
    }

    /**
     * This method is used to validate phone number
     *
     * @param phoneNumber
     * @return true, false
     */
    public boolean phoneNumber(String phoneNumber) {
        String number = "\\d{10}";
        //Creating a pattern object
        Pattern pattern = Pattern.compile(number);
        //Creating a Matcher object
        Matcher matcher = pattern.matcher(phoneNumber);
        //Verifying whether given phone number is valid
        if (matcher.matches()) {
            return true;

        } else {
            return false;
        }
    }
}


