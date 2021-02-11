/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */
package com.ideas2it;

import java.sql.SQLException;

import com.ideas2it.employee.view.EmployeeView;
import com.ideas2it.project.view.ProjectView;

/**
 * This class performs the Employee management process of employee personal and project details
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class EmployeeManagementSystem {

    /**
     * This is the main method to display the user employee personal and project details
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        EmployeeView employeeView = new EmployeeView();
        employeeView.PerforMenuOption();
        ProjectView projectView = new ProjectView();
        projectView.performCrud();
    }
}
