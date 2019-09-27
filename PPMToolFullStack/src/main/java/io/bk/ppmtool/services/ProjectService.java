package io.bk.ppmtool.services;

import io.bk.ppmtool.domain.Project;
import io.bk.ppmtool.exceptions.ProjectIdException;
import io.bk.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project)
    {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception ex)
        {
            throw new ProjectIdException("Project identifier '"+project.getProjectIdentifier()+"' already existing");
        }
    }

    public Project findProjectByIdentify(String projectId)
    {
        Project project  = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project==null)
        {
            throw new ProjectIdException("Project Id '"+projectId.toUpperCase()+"' doesn't exits!");
        }

        return project;
    }
}
