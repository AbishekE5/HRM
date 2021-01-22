package com.ideas2it.project.dao;
import java.sql.SQLException;
import com.ideas2it.project.model.Project;

public interface ProjectDao {
    Project addProjectDetails(Project project) throws SQLException;



    Project deleteProject(int id);
}
