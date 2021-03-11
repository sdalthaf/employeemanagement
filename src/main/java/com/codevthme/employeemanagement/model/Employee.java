package com.codevthme.employeemanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.codevthme.employeemanagement.customvalidators.DOBValidation;
import com.codevthme.employeemanagement.customvalidators.UniqueEmailValidator;



@Entity
@Table(name="employees")
public class Employee {

	@Id
	private Integer emp_id;
	
	@NotNull(message = "Firstname should not be empty")
	@Size(min=1, message="input between 1 to 50 characters!!")
	@Pattern(regexp="^[A-Za-z]*$", message = "Please input alphabet only!!")
	private String first_name;
	
	@NotNull(message = "Lastname should not be empty")
	@Size(min=1, max=50, message="input between 1 to 50 characters!!")
	@Pattern(regexp="^[A-Za-z]*$", message = "Please input alphabet only!!")
	private String last_name;
	
	@NotEmpty(message = "Please select valid gender")
	private String gender;
	
	@NotNull(message = "Please input  Valid date in dd/mm/yyyy format")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@DOBValidation()
	private Date dob;
	
	@Size(min=10, max=10, message = "Please input 10 characters only!")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "please input aphanumeric only!!")
	private String pan_num;
	
	@Size(min=12, max=12, message = "Please input 12 numbers only!")
	@Pattern(regexp="^[0-9]*$", message = "Please input numeric only!")
	private String adhar_num;
	
	@NotNull(message = "Please input valid Mobile number")
	@Size(min=10, max=10, message = "Please input 10 numbers only!")
	@Pattern(regexp="^[0-9]*$", message = "Please input numeric only!")
	private String mobile_num;
	
	@NotNull(message = "Please input a valid email!")
	@Email(message = "Please input a valid email!")
	@UniqueEmailValidator(message = "Email already taken")
	private String email_id;
	
	@NotNull(message = "Please input a valid email!")	
	@Email(message = "Please input a valid email!")
	@UniqueEmailValidator(message = "Email already taken")
	private String office_mail;
	
	@Size(max=200, message = "Text should not exceeds 200 characters!")
	private String permanent_address;
	
	@Size(max=200, message = "Text should not exceeds 200 characters!")
	private String present_address;
	
	private String blood_group;
	
	private String profile_pict;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Please input  Valid date in dd/mm/yyyy format!")
	private Date doj;
	
	@NotNull(message = "Pleasae select a valid employee level")
	private Integer emp_level;
	
	@NotNull(message = "Please input valid Post")	
	@Size(min=1, max=30, message="input between 1 to 30 characters!!")
	@Pattern(regexp="[a-zA-z\\s]*", message = "Please input alphabet only!!")
	private String post_name;
	
	@NotNull(message = "Please input  between 3 to 8 numbers only!")
	@Range(min=100, max=99999999, message = "Please input  between 3 to 8 numbers only!")
	private Integer basic_pay;
	
	@NotNull(message = "Please input  between 3 to 5 numbers only!")
	@Range(min=100, max=99999, message = "Please input  between 3 to 5 numbers only!")
	private Integer house_allowance;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	@Cascade(CascadeType.DELETE)
	private List<EmployeeHistory> employment_history;
	
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPan_num() {
		return pan_num;
	}
	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}
	public String getAdhar_num() {
		return adhar_num;
	}
	public void setAdhar_num(String adhar_num) {
		this.adhar_num = adhar_num;
	}
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getOffice_mail() {
		return office_mail;
	}
	public void setOffice_mail(String office_mail) {
		this.office_mail = office_mail;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}
	public String getPresent_address() {
		return present_address;
	}
	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getProfile_pict() {
		return profile_pict;
	}
	public void setProfile_pict(String profile_pict) {
		this.profile_pict = profile_pict;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Integer getEmp_level() {
		return emp_level;
	}
	public void setEmp_level(Integer emp_level) {
		this.emp_level = emp_level;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public Integer getBasic_pay() {
		return basic_pay;
	}
	public void setBasic_pay(Integer basic_pay) {
		this.basic_pay = basic_pay;
	}
	public Integer getHouse_allowance() {
		return house_allowance;
	}
	public void setHouse_allowance(Integer house_allowance) {
		this.house_allowance = house_allowance;
	}
	
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", dob=" + dob + ", pan_num=" + pan_num + ", adhar_num=" + adhar_num + ", mobile_num="
				+ mobile_num + ", email_id=" + email_id + ", office_mail=" + office_mail + ", permanent_address="
				+ permanent_address + ", present_address=" + present_address + ", blood_group=" + blood_group
				+ ", profile_pict=" + profile_pict + ", doj=" + doj + ", emp_level=" + emp_level + ", post_name="
				+ post_name + ", basic_pay=" + basic_pay + ", house_allowance=" + house_allowance + "]";
	}
	
	
	
	
}
