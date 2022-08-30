package com.example.tasktracker.service;

import com.example.tasktracker.enums.ProjectStatus;
import com.example.tasktracker.enums.TaskStatus;
import com.example.tasktracker.model.Project;
import com.example.tasktracker.model.Task;
import com.example.tasktracker.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

class ProjectServiceTest {
    @Mock
    ProjectRepository projectRepository;
    @InjectMocks
    ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProjects() {
        List<Project> result = projectService.getAllProjects();
        Assertions.assertEquals(Arrays.<Project>asList(new Project(Long.valueOf(1), "name", new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), ProjectStatus.NotStarted, 0, Arrays.<Task>asList(new Task(Long.valueOf(1), "name", "description", TaskStatus.ToDo, 0, null)))), result);
    }

    @Test
    void testGetAllProjectsSortByPriority() {
        List<Project> result = projectService.getAllProjectsSortByPriority("field");
        Assertions.assertEquals(Arrays.<Project>asList(new Project(Long.valueOf(1), "name", new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), ProjectStatus.NotStarted, 0, Arrays.<Task>asList(new Task(Long.valueOf(1), "name", "description", TaskStatus.ToDo, 0, null)))), result);
    }

    @Test
    void testGetProjectById() {
        Project result = projectService.getProjectById(Long.valueOf(1));
        Assertions.assertEquals(new Project(Long.valueOf(1), "name", new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), ProjectStatus.NotStarted, 0, Arrays.<Task>asList(new Task(Long.valueOf(1), "name", "description", TaskStatus.ToDo, 0, null))), result);
    }

    @Test
    void testSave() {
        Project result = projectService.save(new Project(Long.valueOf(1), "name", new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), ProjectStatus.NotStarted, 0, Arrays.<Task>asList(new Task(Long.valueOf(1), "name", "description", TaskStatus.ToDo, 0, null))));
        Assertions.assertEquals(new Project(Long.valueOf(1), "name", new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), ProjectStatus.NotStarted, 0, Arrays.<Task>asList(new Task(Long.valueOf(1), "name", "description", TaskStatus.ToDo, 0, null))), result);
    }

    @Test
    void testDelete() {
        projectService.delete(Long.valueOf(1));
    }

    @Test
    void testUpdate() {
        projectService.update(new Project(Long.valueOf(1), "name", new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), new GregorianCalendar(2022, Calendar.APRIL, 6, 19, 58).getTime(), ProjectStatus.NotStarted, 0, Arrays.<Task>asList(new Task(Long.valueOf(1), "name", "description", TaskStatus.ToDo, 0, null))));
    }

    @Test
    void testUpdateStatus() {
        projectService.updateStatus(Long.valueOf(1), ProjectStatus.NotStarted);
    }
}

