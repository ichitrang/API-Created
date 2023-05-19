package com.example.demo;

import org.springframework
	.stereotype
	.Repository;

// Importing the employees class to
// use the defined properties
// in this class
import com.example.demo.Colleges;

@Repository

// Class to create a list
// of employees
public class CollegeDAO {

	private static Colleges list
		= new Colleges();

	// This static block is executed
	// before executing the main
	// block
	static
	{

		// Creating a few employees
		// and adding them to the list
		list.getcollegeList().add(
			new College(
				1,
				"Prem",
				"Tiwari",
				"chapradreams@gmail.com"));

		list.getcollegeList().add(
			new College(
				2, "Vikash",
				"Kumar",
				"abc@gmail.com"));

		list.getcollegeList().add(
			new College(
				3, "Ritesh",
				"Ojha",
				"asdjf@gmail.com"));

		 
	}

	// Method to return the list
	public Colleges getAllColleges()
	{

		return list;
	}

	 
		// Method to add an employee
		// to the employees list
		public void
		addCollege(College college)
	{
		list.getcollegeList()
			.add(college);
		 
	}
}
