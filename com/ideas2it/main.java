package com.ideas2it;
/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fiels
 */
import java.sql.SQLException;
import com.ideas2it.employee.view.AddressView;
import com.ideas2it.employee.view.EmployeeView;
import com.ideas2it.project.view.ProjectView;

public class main {
    public static void main(String[] args) throws SQLException {
        EmployeeView view = new EmployeeView();
        view.performCrud();
        AddressView view1 = new AddressView();
        view1.performCrud();
        ProjectView view2 = new ProjectView();
        view2.performCrud();
    }
}
