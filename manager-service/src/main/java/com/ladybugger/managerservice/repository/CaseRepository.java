package com.ladybugger.managerservice.repository;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ladybugger.managerservice.model.Case;

@Repository
public interface CaseRepository extends PagingAndSortingRepository<Case, Long>{
    Optional<Case> findById(int id);
	Boolean existsByid(String id);
}
