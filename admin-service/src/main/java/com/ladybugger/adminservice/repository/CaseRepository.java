package com.ladybugger.adminservice.repository;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ladybugger.adminservice.model.Case;

@Repository
public interface CaseRepository extends PagingAndSortingRepository<Case, Long>{
    Optional<Case> findById(int id);
	Boolean existsByid(String id);
}
