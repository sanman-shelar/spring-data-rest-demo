package com.rest;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
		ParentTable p1 = new ParentTable();
		p1.setSsn("34343434");
		p1.setAttr("N");
		
		ChildTable c1 = new ChildTable();
		c1.setCattr("NY");
		
		ChildTable c2 = new ChildTable();
		c2.setCattr("CA");
		
		p1.getChildTable().add(c1);
		p1.getChildTable().add(c2);
		
		dataRepository.saveAndFlush(p1);		

		return p1;
	}
	
	@PutMapping
	public @ResponseBody ParentTable deleteData(@RequestBody ParentTable parentTable) {
		Optional<ParentTable> op2 = dataRepository.findById(parentTable.getId());
		
		ParentTable p2 = op2.get();
		
		ChildTable c3 = new ChildTable();
		c3.setCattr("DZ");
		
		Set<ChildTable> x = p2.getChildTable().stream().collect(Collectors.toSet());
		x.add(c3);
		
		p2.getChildTable().add(c3);
		dataRepository.save(p2);
		return p2;
	}
	
	@DeleteMapping
	public @ResponseBody String deleteData(String ssn) {
		dataRepository.deleteAll(dataRepository.findBySsn(ssn).get());
		return "deleted";
	}
}
