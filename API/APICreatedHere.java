package com.example.demo;

import java.net.URI;
import org.springframework.beans
	.factory.annotation.Autowired;
import org.springframework.http
	.ResponseEntity;
import org.springframework.web.bind
	.annotation.GetMapping;
import org.springframework.web.bind
	.annotation.PostMapping;
import org.springframework.web.bind
	.annotation.RequestBody;
import org.springframework.web.bind
	.annotation.RequestMapping;
import org.springframework.web.bind
	.annotation.RestController;
import org.springframework.web.servlet
	.support.ServletUriComponentsBuilder;

// Import the above-defined classes
// to use the properties of those
// classes
import com.example.demo.Colleges;
import com.example.demo.CollegeDAO;
import com.example.demo.College;

// Creating the REST controller
@RestController
@RequestMapping(path = "/colleges")
public class CollegeController {

	@Autowired
 private CollegeDAO collegeDao;
	 
		// Implementing a GET method
		// to get the list of all
		// the employees
 @GetMapping(
		path = "/",
		produces = "application/json")

	public Colleges getColleges()
	{

		return CollegeDao
			.getAllColleges();
	}

	 
		// Create a POST method
		// to add an employee
		// to the list
 @PostMapping(
		path = "/",
		consumes = "application/json",
		produces = "application/json")

	public ResponseEntity<Object> addCollege(
		@RequestBody College college)
	{

		// Creating an ID of an employee
		// from the number of employees
		Integer id
			= CollegeDao
				.getAllColleges()
				.getcollegeeList()
				.size()
			+ 1;

		college.setId(id);

		collegeDao
			.addCollege(college);

		URI location
			= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(
					college.getId())
				.toUri();

		   return ResponseEntity
			.created(location)
			.build();
	}
}
