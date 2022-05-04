package com.ladybugger.adminservice.repository;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ladybugger.adminservice.model.Project;


@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{
    Optional<Project> findById(int id);
	Boolean existsByid(String id);
}
