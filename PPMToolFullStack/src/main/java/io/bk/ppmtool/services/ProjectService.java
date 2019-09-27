package io.bk.ppmtool.services;

import io.bk.ppmtool.domain.Project;
import io.bk.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project)
    {
        // Logic
        return projectRepository.save(project);
    }

}
