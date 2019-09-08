package com.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parent_table")
@NoArgsConstructor
@Data
public class ParentTable {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String ssn;
	private String attr;
	private LocalDate endDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id", nullable = false, updatable = false)
	private List<ChildTable> childTable = new ArrayList<>();
	
	public ParentTable(ParentTable parentTable) {
		
		this.ssn = parentTable.ssn;
		this.attr = parentTable.attr;
		this.endDate = parentTable.endDate;
		
		this.childTable.addAll(parentTable.getChildTable().stream().map(e -> new ChildTable(e)).collect(Collectors.toList()));
		
	}
}
