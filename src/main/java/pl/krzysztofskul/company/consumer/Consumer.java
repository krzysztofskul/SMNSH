package pl.krzysztofskul.company.consumer;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;

//@Entity
public class Consumer extends Company {

	private String building;
	
	private String floor;
	
	private String departmentName;
	private String departmentId;
	
	private String roomName;
	private String roomNo;
	
	private String personResponsible;
}
