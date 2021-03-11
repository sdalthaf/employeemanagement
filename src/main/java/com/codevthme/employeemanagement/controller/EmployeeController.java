package com.codevthme.employeemanagement.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.codevthme.employeemanagement.model.Employee;
import com.codevthme.employeemanagement.model.EmployeeHistory;
import com.codevthme.employeemanagement.service.EmployeeService;

@Controller
public class EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	public static boolean UPDATE_EMPLOYEE_FLAG = false;
	
	public static List<Employee> currentList;
	
	
	@RequestMapping("/index")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
			if(logger.isDebugEnabled()) {
				logger.debug("Invoking getAllEmployeesOrderBy() method"); 
			}
			
			List<Employee> employees = employeeService.getAllEmployeesOrderBy();
			currentList = employees;
			if(logger.isDebugEnabled()) {
				logger.debug("Adding employee object and view to ModelAndView"); 
			}
			
			mv.addObject("employees", employees);
			mv.setViewName("index");
			
		logger.debug("returning model and view object");
		return mv;		
	}
	
	//Added init binder to trim extra spaces
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	//show employee adding employee form
	@RequestMapping("/addEmployee")
	public String showAddEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST, params = "save")
	public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee,
										BindingResult bindResult, RedirectAttributes ra) {
			if(logger.isDebugEnabled()) {
				logger.debug("Validating form fields for add employee"); 
			}
			
			if(bindResult.hasErrors()) {
				if(logger.isDebugEnabled()) {
					logger.debug("Add employee form has errors kindly check the form for error details"); 
				}
				return "addEmployee";
			}
				
			logger.warn("Adding Employee details");
			boolean flag = employeeService.saveEmployee(employee);
			if(flag) {
				logger.warn("Employee has been saved successfully");
				ra.addFlashAttribute("responseMessage", "Employee has been saved successfully.");
			} else {
				ra.addFlashAttribute("responseMessage", "failed to save employee!!.");
			}
			
			
			
		return "redirect:/index";
	}
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST, params = "cancel")
	public String cancel() {
		return "redirect:/index";
	}
	
	
	@RequestMapping(value = "delete/{emp_id}", method = RequestMethod.GET)
	public String delete(@PathVariable("emp_id") Integer id, RedirectAttributes ra) {
		logger.warn("Deleting employee : "+id);
		employeeService.deleteEmployee(id);
		logger.warn("Employee has been deleted succesfully!!");
		ra.addFlashAttribute("deleteResponse", "Employee has been deleted successfully.");
		return "redirect:/index";
	}
	
	
	//show employee update form
	@RequestMapping(value = "employee/{emp_id}", method = RequestMethod.GET)
	public String showUpdateEmployeeForm(@PathVariable("emp_id") Integer id, Model model) {
		logger.debug("Updating employee");
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		UPDATE_EMPLOYEE_FLAG  = true;
		return "update-employee";
	}
	
	@RequestMapping(value="employee/updateEmployee", method=RequestMethod.POST, params = "update")
	public String updateEmployee(@Validated @ModelAttribute("employee") Employee employee,
										BindingResult bindResult, RedirectAttributes ra) {
		
			if(bindResult.hasErrors()) {
				logger.debug("Updating employee failed check the form errors");
				return "update-employee";
				
			}
			
			logger.warn("Updating the details to database");
			employeeService.updateEmployee(employee);
			logger.warn("Employee has been updated successfully : " + employee.getEmp_id());
			ra.addFlashAttribute("updateResponse", "Employee has been updated successfully.");
			UPDATE_EMPLOYEE_FLAG = false;
		return "redirect:/index";
	}
	
	@RequestMapping(value="employee/updateEmployee", params = "cancel")
	public String cancelUpdate() {
		return "redirect:/index";
	}
	
	
	@RequestMapping(value = "employee-history/{emp_id}", method = RequestMethod.GET)
	public ModelAndView history(@PathVariable("emp_id") Integer id) {
		
		logger.warn("Fetching Employee Details..");
		Employee employee = employeeService.getEmployeeById(id);
		ModelAndView mv = new ModelAndView();
		logger.warn("Fetching Employee History Details..");
		List<EmployeeHistory> employeeHistory = employeeService.getEmployeeHistory(id);
		mv.addObject("employeeHistory", employeeHistory);
		mv.addObject("employee", employee);
		mv.setViewName("employment-history");
		return mv;
	}
	
	
	@RequestMapping(value="/downloadCSV", method=RequestMethod.POST)
	public String downloadCSV(HttpServletResponse response) throws IOException {
		
		logger.warn("Invoked downloadCSV");
		response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Employee_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
		logger.warn("Fetching all available employee records");
        List<Employee> listUsers = employeeService.getAllEmployees();
		logger.warn("Succesfully fetched all employees, preparing csv...");

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Emp Id", "Name", "Doj", "Post", "Level", "Mobile", "Personal mail", "Office mail", "Dob", "Blood Group", "Pan number","Adhar number" };
        String[] nameMapping = {"emp_id", "first_name", "doj", "post_name", "emp_level", "mobile_num", "email_id", "office_mail", "dob", "blood_group", "pan_num", "adhar_num" };
         
        csvWriter.writeHeader(csvHeader);

        for (Employee user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
        
        csvWriter.close();
		logger.warn("csv downloaded successfully");

		return "index";
	}
	
	
}
