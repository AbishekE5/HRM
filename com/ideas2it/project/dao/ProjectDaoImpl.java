/**
 * {@inheritDoc}
 */
package com.ideas2it.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ideas2it.project.dao.Impl.ProjectDao;
import com.ideas2it.project.model.Project;
import com.ideas2it.util.Datasource;

/**
 * {@inheritDoc}
 */
public class ProjectDaoImpl implements ProjectDao {

    private final String INSERT_USERS_SQL = "INSERT INTO project1 (description, timeEstimation, budget, projectName) VALUES (?, ?, ?, ?);";
    private final String SELECT_ALL_USERS = "select projectId, description, timeEstimation, budget, projectName, status from project1";
    private final String SELECT_USER_BY_ID = "select projectId, description, timeEstimation, budget, projectName, status from project1 where projectID =?";
    private final String SELECT_AUTO_ID = "(select max(projectID) from project1)";
    private final String DELETE_USERS_SQL = "update project1 SET status=0  where projectID = ?;";
    private final String UPDATE_USERS_SQL = "update project1 set  description = ?, timeEstimation = ?, budget = ?, projectName =?  where projectID = ?";

    /**
     * {@inheritDoc}
     */
    @Override
    public Project insertProject(Project project) {
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
            preparedStatement= connection.prepareStatement(SELECT_AUTO_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            project.setProjectId(resultSet.getInt("max(projectID)"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return project;
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public Project getProjectById(int projectId) throws SQLException {
        Project project = null;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, projectId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                project = new Project();
                project.setProjectId(rs.getInt(1));
                project.setDescription(rs.getString(2));
                project.setTimeEstimation(rs.getString(3));
                project.setBudget(rs.getString(4));
                project.setProjectName(rs.getString(5));
                connection.close();
                return project;
            }
            else {
                return project;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return project;
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> viewProject(List<Project> project) throws SQLException {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int projectId=rs.getInt(1);
                String description=rs.getString(2);
                String timeEstimation=rs.getString(3);
                String budget=rs.getString(4);
                String projectName=rs.getString(5);
                project.add(new Project(projectId,description,timeEstimation,budget,projectName));
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return project;
    }
}

