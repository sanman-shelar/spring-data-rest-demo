package com.rest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "child_table")

public class ChildTable {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String cid;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", unique = true)
	private ParentTable parentTable;

	private String cattr;

	public ChildTable() {
		super();
	}

	public ChildTable(String cid, ParentTable parentTable, String cattr) {
		super();
		this.cid = cid;
		this.parentTable = parentTable;
		this.cattr = cattr;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public ParentTable getParentTable() {
		return parentTable;
	}

	public void setParentTable(ParentTable parentTable) {
		this.parentTable = parentTable;
	}

	public String getCattr() {
		return cattr;
	}

	public void setCattr(String cattr) {
		this.cattr = cattr;
	}
	
	public String toString() {
		return "ChildTable [cid=" + cid + ", parentTable=" + parentTable.getId() + ", cattr=" + cattr + "]";
	}
}
