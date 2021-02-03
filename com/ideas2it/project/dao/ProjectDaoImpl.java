/**
 * Provides the necessary information to create Project Dao Implementation class
 * To communicate with the sql server database and to convert the project object to table
 */
package com.ideas2it.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ideas2it.project.dao.DaoImpl.ProjectDao;
import com.ideas2it.project.model.Project;
import com.ideas2it.util.Datasource;

/**
 * This class implements Project interface method
 */
public class ProjectDaoImpl implements ProjectDao {
    private final String INSERT_USERS_SQL = "INSERT INTO project" + " (projectId,description,timeEstimation,budget,projectName) VALUES " + " (?,?,?,?,?);";

    private final String SELECT_USER_BY_ID = "Select projectId, description, timeEstimation, budget, projectName, status from project where projectID =?";

    private final String SELECT_ALL_USERS = "select projectId, description, timeEstimation, budget, projectName, status from project";

    private final String DELETE_USERS_SQL = "update project SET status=0  where projectID = ?;";

    private final String UPDATE_USERS_SQL = "update project set  description = ?, timeEstimation = ?, budget = ?, projectName =?  where projectID = ?";

    /**
     * This method is used to create project details in the project table
     */
    @Override
    public Project addProjectbyId(Project project) {
        System.out.println(INSERT_USERS_SQL);
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getBudget());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setString(4, project.getTimeEstimation());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return project;
    }

    /**
     * This method is used to update project details in the project table
     */
    @Override
    public int updateProjectById(int projectId, String description, String timeEstimation, String budget, String projectName) {
        int rowCount = 0;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, description);
            preparedStatement.setString(2, timeEstimation);
            preparedStatement.setString(3, budget);
            preparedStatement.setInt(5, projectId);
            rowCount = preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowCount;
    }

    /**
     * This method is used to delete project details in the project table
     * @param projectId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteProjectById(int projectId) throws SQLException {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, projectId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return projectId;
    }

    /**
     *
     * @param projectId
     * @return projectId
     * @throws SQLException
     */
    @Override
    public int getProjectById(int projectId) throws SQLException {
        Project project = new Project();
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, projectId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                project.setProjectId(rs.getInt(1));
                project.setDescription(rs.getString(2));
                project.setTimeEstimation(rs.getString(3));
                project.setBudget(rs.getString(4));
                project.setProjectName(rs.getString(5));
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return projectId;
    }
}

