package com.ideas2it;

import com.ideas2it.employee.view.EmployeeView;
import com.ideas2it.project.view.ProjectView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeView view = new EmployeeView();
        view.performCrud();
        ProjectView view1 = new ProjectView();
        view1.performCrud();

    }
}
