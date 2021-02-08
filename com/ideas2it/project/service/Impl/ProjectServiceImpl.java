/**
 * {@inheritDoc}
 */
package com.ideas2it.project.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.project.dao.ProjectDaoImpl;
import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.ProjectService;

/**
 * {@inheritDoc}
 */
public class ProjectServiceImpl implements ProjectService {

    ProjectDaoImpl projectDao = new ProjectDaoImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public Project insertProject(String projectName, String timeEstimation, String budget,String description) {
        Project project = new Project(projectName,timeEstimation,budget,projectName);
        return projectDao.insertProject(project);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteProject(int projectId) throws SQLException {
        return projectDao.deleteProjectById(projectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateProject(int projectId, String projectName, String timeEstimation, String budget,String description) {
        return projectDao.updateProjectById(projectId, description, timeEstimation, budget, projectName);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Project getProjectById(int projectId) throws SQLException {
        return projectDao.getProjectById(projectId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> viewProject(List<Project> project) throws SQLException {
        return projectDao.viewProject(project);
    }

}

