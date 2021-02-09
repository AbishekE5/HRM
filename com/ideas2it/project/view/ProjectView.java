/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */
package com.ideas2it.project.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.project.controller.ProjectController;
import com.ideas2it.project.model.Project;

/**
 * This class interacts with the user of employee details
 */
public class ProjectView {
    ProjectController projectController = new ProjectController();

    /**
     * This method is used to prompt user to enter menu options.
     */
    public static int menu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new project.");
        System.out.println("2) Delete a project via project ID");
        System.out.println("3) update an project via project ID");
        System.out.println("4) retrieve an project via project ID ");
        System.out.println("5) view All ");
        System.out.println("6) exit ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * This method is used to perform the CRUD operations
     */
    public void performCrud() throws SQLException {
        int menuStore = menu();
        while (menuStore != 6) {
            System.out.println();
            switch (menuStore) {
                case 1:
                    this.insertProject();
                    break;

                    case 2:
                    this.deleteProject();

                    break;

                case 3:
                    this.updateproject();
                    break;

                case 4:
                    this.getProjectById();
                    break;

                case 5:
                    this.viewProject();
                    break;

                    case 6:
                    return;
            }
            menuStore = menu();
        }
    }

    /**
     * This method is used to add a new employee
     */
    public void insertProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Time: ");
        String timeEstimation = scanner.nextLine();
        System.out.println("Enter Budget: ");
        String budget = scanner.nextLine();
        System.out.println("Enter Project Name: ");
        String projectName = scanner.nextLine();
        Project project =projectController.insertProject(description,timeEstimation,budget,description);
        System.out.println("Project Successfully created. Project ID  " +project.getProjectId());
    }

    /**
     * This method is used to perform the delete operations
     */
    public void deleteProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Project-ID of the employee you wish to delete: ");
        int projectId = scanner.nextInt();
        projectController.deleteProject(projectId);
        System.out.println("Project Successfully deleted");
    }

    /**
     * This method is used to perform the retrive operations
     */
    public void updateproject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Project-id of the employee you wish to update: ");
        int projectId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new Project Name");
        String projectName = scanner.nextLine();
        System.out.println("Enter new timeEstimation ");
        String timeEstimation = scanner.nextLine();
        System.out.println("Enter new budget: ");
        String bugdet = scanner.nextLine();
        System.out.println("Enter new Description: ");
        String description = scanner.nextLine();
        int employee = projectController.updateProject(projectId, projectName, timeEstimation, bugdet, description);
        System.out.println(employee);
    }

    /**
     * This method is used to perform the retrieve operations
     */
    public void getProjectById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Project-ID of the employee you wish to retrieve: ");
        int projectId = scanner.nextInt();
        Project project = projectController.getProjectById(projectId);
        if(project == null){
            System.out.println("Project ID not found");
        }
        else{
            System.out.println(project);
        }
    }

    /**
     * This method is used to view all project details
     */
    public void viewProject() throws SQLException {
        List<Project> project = new ArrayList<Project>();
        projectController.viewAllProject(project);
        System.out.println(project);
    }
}
