package com.ideas2it.project.view;

import com.ideas2it.project.controller.ProjectController;
import com.ideas2it.project.model.Project;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectView {
    ProjectController controller = new ProjectController();
    Project project = new Project();
    /**
     * This method is used to prompt user to enter menu options.
     */

    public static int menu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new Project.");
        System.out.println("2) Delete an project via Project-ID.");
        System.out.println("3) Retrive an project via Project-ID.");
        System.out.println("4) Exit.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
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
                    this.addProject();

                    break;
                /* Case to delete the employee details with user input */
                case 2:
                    this.deleteProject();

                    break;

                /* case to retrive data using employee-id */
                case 3:
                    this.retrieveProject();
                    break;

                case 4:
                    return;
            }
            menuStore = menu();
        }


    }
    /**
     * This method is used to add a new project
     */

    public void addProject() throws SQLException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter a Projectid: ");
        Integer projectId = Integer.parseInt(scanner1.nextLine());

        System.out.println("Enter Description: ");
        String projectName = scanner1.nextLine();
        System.out.println("Enter Project Name");
        String timeEstimation = scanner1.nextLine();

        System.out.println("Enter Time Estimation");
        String bugdet = scanner1.nextLine();

        System.out.println("Enter Budget");
        String description = scanner1.nextLine();

        Project project = controller.createProject(projectId,projectName,timeEstimation,bugdet,description);

        System.out.println("Employee Successfully created");
    }
    /**
     * This method is used to delete a new employee
     */

    public void deleteProject(){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter the Project-ID of the employee you wish to delete: ");
        Integer delete = scanner2.nextInt();
        controller.deleteProject(delete);
        System.out.println("Project Successfully deleted");
    }
    /**
     * This method is used to retrive a new employee
     */

    public void retrieveProject() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Please enter the Project-id of the employee you wish to retrive: ");
        Integer retrive = scanner3.nextInt();
        Project e1 =controller.getProjectById(retrive);
        System.out.println(e1);

    }

}
