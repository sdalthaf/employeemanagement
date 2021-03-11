package com.codevthme.employeemanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="employment_history")
public class EmployeeHistory {

	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	private String organization_name;
	
	private Date from_date;
	
	private Date until_date;
	
	private String location;
	
	private String country;
	
	private String post;
	
	private String skill_used;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getUntil_date() {
		return until_date;
	}

	public void setUntil_date(Date until_date) {
		this.until_date = until_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getSkill_used() {
		return skill_used;
	}

	public void setSkill_used(String skill_used) {
		this.skill_used = skill_used;
	}

	@Override
	public String toString() {
		return "EmployeHistory [id=" + id + ", employee=" + employee + ", organization_name=" + organization_name
				+ ", from_date=" + from_date + ", until_date=" + until_date + ", location=" + location + ", country="
				+ country + ", post=" + post + ", skill_used=" + skill_used + "]";
	}
	
	
	
	
}
