/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */
package com.ideas2it.project.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.ideas2it.project.controller.ProjectController;

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
        System.out.println("1) Add a new employee.");
        System.out.println("2) Delete an employee via Emp-ID.");
        System.out.println("3) update an employee via Emp-ID.");
        System.out.println("4) retrieve an employee via Emp-ID. ");
        System.out.println("5) exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * This method is used to perform the CRUD operations
     */
    public void performCrud() throws SQLException {
        int menuStore = menu();
        while (menuStore != 5) {
            System.out.println();
            switch (menuStore) {

                /* switch statement to create employee details */
                case 1:
                    this.createProject();

                    break;
                /* Case to delete the employee details with user input */
                case 2:
                    this.deleteProject();

                    break;

                /* case to retrive data using employee-id */
                case 3:
                    this.updateproject();
                    break;

                case 4:
                    return;
            }
            menuStore = menu();
        }
    }

    /**
     * This method is used to add a new employee
     */
    public void createProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a projectId: ");
        int projectId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter projectName: ");
        String projectName = scanner.nextLine();
        System.out.println("Enter time Estimation: ");
        String timeEstimation = scanner.nextLine();
        System.out.println("Enter Budget: ");
        String bugdet = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        projectController.createProject(projectId, projectName, timeEstimation, bugdet, description);
        System.out.println("Employee Successfully created");
    }

    /**
     * This method is used to perform the delete operations
     */
    public void deleteProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Project-ID of the employee you wish to delete: ");
        int employeeId = scanner.nextInt();
        projectController.deleteProject(employeeId);
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
}
