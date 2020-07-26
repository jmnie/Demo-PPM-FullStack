package jmnie.demoproject.ppmtool.repositories;


import jmnie.demoproject.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

    Project findByProjectIdentifier(String ProjectID);

    @Override
    Iterable<Project> findAll();



}
