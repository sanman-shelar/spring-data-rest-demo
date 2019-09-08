package com.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DataRepository extends JpaRepository<ParentTable, String> {
	
	public Optional<List<ParentTable>> findBySsn(String ssn);
	
	@Query("select distinct p from ParentTable p join fetch p.childTable c where p.endDate = :pEndDate and c.endDate = :cEndDate and c.cattr = :cattr")
	public Optional<List<ParentTable>> findByChildTable(@Param("cattr") String cattr, @Param("pEndDate") LocalDate pEndDate, @Param("cEndDate") LocalDate cEndDate);
	
	
}
