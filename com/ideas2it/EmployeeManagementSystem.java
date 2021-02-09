package com.ideas2it;
/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */
import java.sql.SQLException;
import com.ideas2it.employee.view.AddressView;
import com.ideas2it.employee.view.EmployeeView;
import com.ideas2it.project.view.ProjectView;

public class EmployeeManagementSystem {

    public static void main(String[] args) throws SQLException {
        EmployeeView employeeView = new EmployeeView();
        employeeView.performCrud();
        AddressView addressView = new AddressView();
        addressView.performCrud();
        ProjectView projectView = new ProjectView();
        projectView.performCrud();
    }
}
