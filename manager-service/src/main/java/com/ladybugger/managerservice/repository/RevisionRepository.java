package com.ladybugger.managerservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladybugger.managerservice.model.Revision;


@Repository
public interface RevisionRepository extends JpaRepository<Revision, Long>{
    Optional<Revision> findById(int id);
	Boolean existsByid(String id);
}
