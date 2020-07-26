package jmnie.demoproject.ppmtool.services;

import jmnie.demoproject.ppmtool.domain.Project;
import jmnie.demoproject.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        //Logic
        return  projectRepository.save(project);
    }

}
