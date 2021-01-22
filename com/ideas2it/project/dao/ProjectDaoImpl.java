package com.ideas2it.project.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ideas2it.util.Datasource;
import com.ideas2it.project.model.Project;

public class ProjectDaoImpl implements ProjectDao{
    private static final String INSERT_USERS_SQL = "INSERT INTO project" + " (projectId,Description,projectName,TimeEstimation,budget) VALUES " + " (?,?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "Select Description,projectName,TimeEstimation,budget from project where projectId =?";

    private static final String SELECT_ALL_USERS = "select * from project";

    private static final String DELETE_USERS_SQL = "delete from project where project Id = ?;";

    private static final String UPDATE_USERS_SQL = "update project set Description = ? Time estimation = ? budget = ? project Name = ? where project Id = ?";

    /**
     * This method is used to create the project details.
     * @param project
     * @return project
     */

    @Override
    public Project addProjectDetails(Project project) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, project.getProjectId());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getTimeEstimation());
            preparedStatement.setString(4, project.getBudget());
            preparedStatement.setString(5, project.getProjectName());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return project;
    }

    /**
     * This method is used to delete the project details.
     * @param id
     * @return project
     */
    @Override
    public Project deleteProject(int id) {
        Project project = new Project();

        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return project;

    }

    /**
     * This method is used to update the project details.
     * @param project
     * @return project
     */
    public Project updateProject(Project project) {


        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);

            preparedStatement.setString(1, project.getDescription());
            preparedStatement.setString(2, project.getTimeEstimation());
            preparedStatement.setString(3, project.getBudget());
            preparedStatement.setString(4, project.getProjectName());
            preparedStatement.setInt(5, project.getProjectId());
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return project;
    }
    /**
     * This method is used to retrive the project details.
     * @param id
     * @return project
     */
    public static Project getProjectById(int id) {
        Project project = new Project();

        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                project.setProjectId(rs.getInt(1));
                project.setDescription(rs.getString(2));
                project.setTimeEstimation(rs.getString(3));
                project.setBudget(rs.getString(4));
                project.setProjectName(rs.getString(5));
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return project;
    }

}

