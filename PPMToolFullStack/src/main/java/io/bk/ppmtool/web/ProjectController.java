package io.bk.ppmtool.web;

import io.bk.ppmtool.domain.Project;
import io.bk.ppmtool.services.MapValidationErrorService;
import io.bk.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }

        Project projectCreated = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(projectCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId)
    {
        Project project = projectService.findProjectByIdentify(projectId);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
}
