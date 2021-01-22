package com.ideas2it.project.controller;
import java.sql.SQLException;
import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.ProjectService;



public class ProjectController {
    /**
     * This method is used to send the user input to create employee details.
     * @param projectId This is the first parameter to create Employee
     * @param projectName  This is the second parameter to create Employee
     * @param timeEstimation  This is the third parameter to createEmployee
     * @param budget This is the fourth parameter to createEmployee
     * @param description  This is the fifth parameter to createEmployee
     * @return projectId,projectName,timeEstimation,bugdet,description
     */
    ProjectService service = new ProjectService();
    public Project createProject(Integer projectId, String projectName, String timeEstimation, String bugdet,String description) throws SQLException {
        return service.createProject(projectId,projectName,timeEstimation,bugdet,description);

    }
    /**
     * This method is used to send the user input to retrive employee details.
     * @param id This is the  parameter to retrive Employee
     * @return retrive
     */
    public Project getProjectById(int id){
        return service.getProjectById(id);
    }
    /**
     * This method is used to send the user input to delete employee details.
     * @param delete This is the  parameter to delete Employee
     * @return delete
     */

    public Project deleteProject(Integer delete){
        return service.deleteProject(delete);

    }

    /**
     * This method is used to send the user input to update employee details.
     *
     * @return delete
     */

    public Project updateProject(Integer update, String projectName, String timeEstimation, String bugdet, String description) {
        return service.updateproject(update,projectName,timeEstimation,bugdet,description);
    }
}
