package jmnie.demoproject.ppmtool.services;

import jmnie.demoproject.ppmtool.domain.Project;
import jmnie.demoproject.ppmtool.exceptions.ProjectIdException;
import jmnie.demoproject.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        }catch (Exception e){
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists.");
        }
    }

    public Project findProjectByIdentifier(String ProjectId){
        Project project = projectRepository.findByProjectIdentifier(ProjectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID'" + ProjectId + "' does not exist.");

        }

        return project;

    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if(project == null){
            throw new ProjectIdException("Cannot project with ID '" + projectId + "' this project does not exist. ");
        }

        projectRepository.delete(project);
    }
}
