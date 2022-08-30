package com.example.tasktracker.service;

import com.example.tasktracker.enums.ProjectStatus;
import com.example.tasktracker.model.Project;
import com.example.tasktracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//Project service class, provides the logic
public class ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    //Get all projects sorted by concrete field
    public List<Project> getAllProjectsSortByPriority(String field) {
        return projectRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    //Get project by id
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).get();
    }

    //Add new project
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    //Delete project by id
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    //Update project by id
    public void update(Project project) {
        projectRepository.updateNameOrEndDateOrStartDateOrStatusOrPriorityById(project.getName(), project.getEndDate(),
                project.getStartDate(), project.getStatus(), project.getPriority(), project.getId());
    }

    //Update project's status
    public void updateStatus(Long id, ProjectStatus status) {
        projectRepository.updateStatusBy(status, id);
    }
}
