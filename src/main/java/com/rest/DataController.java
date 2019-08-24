package com.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

	@Autowired
	DataRepository dataRepository;

	@GetMapping
	public @ResponseBody List<ParentTable> getAllData() {
		return dataRepository.findAll();
	}

	@GetMapping("/id/{id}")
	public @ResponseBody Optional<ParentTable> findDataUsingId(@PathVariable String id) {
		return dataRepository.findById(id);
	}

	@GetMapping("/st/{cattr}")
	public @ResponseBody Optional<List<ParentTable>> findDataUsingAttribute(@PathVariable String cattr) {
		return dataRepository.findByChildTable(cattr);
	}

	@PostMapping
	public @ResponseBody ParentTable postData(@RequestBody ParentTable parentTable) {
		dataRepository.saveAndFlush(parentTable);
		return parentTable;
	}
	
	@PutMapping
	public @ResponseBody ParentTable deleteData(@RequestBody ParentTable parentTable) {
		dataRepository.save(parentTable);
		return parentTable;
	}
	
	@DeleteMapping
	public @ResponseBody String deleteData(String ssn) {
		dataRepository.deleteAll(dataRepository.findBySsn(ssn).get());
		return "deleted";
	}
}
