package com.ladybugger.managerservice.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladybugger.managerservice.model.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long>{
    Optional<Submission> findById(int id);
	Boolean existsByid(String id);    
}
