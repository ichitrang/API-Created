package com.example.demo;

import java.util.ArrayList;
import java.util.List;

// Class to store the list of
// all the employees in an
// Array List
public class Colleges {

	private List<College> collegeList;

	// Method to return the list
	// of employees
	public List<College> getcollegeList()
	{

		if (collegeList == null) {

			collegeList
				= new ArrayList<>();

			   
		}

		return collegeList;

		 
	}

	public void
	setcollegeList(
		List<College> collegeList)
	{
		this.collegeList
			= collegeList;
	}
}
