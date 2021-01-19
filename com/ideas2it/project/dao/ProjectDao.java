package com.ideas2it.project.dao;

import com.ideas2it.project.model.Project;

import java.sql.SQLException;

public interface ProjectDao {
    Project addProjectDetails(Project project) throws SQLException;



    Project deleteProject(int id);
}
