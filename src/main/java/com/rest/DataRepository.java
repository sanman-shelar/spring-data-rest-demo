package com.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DataRepository extends JpaRepository<ParentTable, String> {
	
	public Optional<List<ParentTable>> findBySsn(String ssn);
	
	@Query("select distinct p from ParentTable p join p.childTable c where c.cattr = :cattr")
	public Optional<List<ParentTable>> findByChildTable(@Param("cattr") String cattr);
	
}
