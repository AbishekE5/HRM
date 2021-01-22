package com.ideas2it.project.service;

import java.sql.SQLException;
import com.ideas2it.project.dao.ProjectDaoImpl;
import com.ideas2it.project.model.Project;


public class ProjectService {
    ProjectDaoImpl dao = new ProjectDaoImpl();

    /**
     * This method is used to create the employee details.
     *
     * @param projectId      This is the first parameter to create Employee
     * @param projectName    This is the second parameter to create Employee
     * @param timeEstimation This is the third parameter to createEmployee
     * @param budget         This is the fourth parameter to createEmployee
     * @param description    This is the fifth parameter to createEmployee
     * @return prjectByKey
     */

    public Project createProject(Integer projectId, String projectName, String timeEstimation, String budget, String description) throws SQLException {
        Project project = new Project(projectId, projectName, timeEstimation, budget, description);
        return dao.addProjectDetails(project);
    }

    /**
     * This method is used to delete the employee details.
     *
     * @param delete
     * @return delete
     */

    public Project deleteProject(Integer delete) {
        return dao.deleteProject(delete);
    }

    /**
     * This method is used to retrive the employee details.
     *
     * @param retrive
     * @return true, false
     */



    /**
     * This method is used to retrive the employee details.
     *
     * @param id
     * @return recievedProject
     */

    public Project getProjectById(int id) {
        return dao.getProjectById(id);
    }

    public Project updateproject(Integer update, String projectName, String timeEstimation, String bugdet, String description) {
        Project project = new Project(update,description,timeEstimation,bugdet,projectName);
        return dao.updateProject(project);
    }
}
