package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "parent_table")
public class ParentTable {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String ssn;
	private String attr;

	@JsonManagedReference
	@OneToMany(mappedBy = "parentTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChildTable> childTable = new ArrayList<>();

	public ParentTable() {
		super();
	}

	public ParentTable(String id, String ssn, String attr, List<ChildTable> childTable) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.attr = attr;
		this.childTable = childTable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public List<ChildTable> getChildTable() {
		return childTable;
	}

	public void setChildTable(List<ChildTable> childTable) {
		this.childTable = childTable;
	}

	public String toString() {
		return "ParentTable [id=" + id + ", ssn=" + ssn + ", attr=" + attr + ", " + childTable + "]";
	}
}
