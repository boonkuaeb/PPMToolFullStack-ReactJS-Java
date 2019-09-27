package io.bk.ppmtool.web;

import io.bk.ppmtool.domain.Project;
import io.bk.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createNewProject(@RequestBody Project project)
    {
        Project projectCreated = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(projectCreated, HttpStatus.CREATED);
    }
}
