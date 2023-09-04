package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	public EmployeeService employeeService;

	//constructor injection
	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
//get the employees from the database
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}
//--this will show the form start
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		//create model attribute to bind from data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);

		//src/main/resources/templates/employees/employee-form.html
		return "employees/employee-form";
		//--this will show the form end
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employees")Employee theEmployee){

		//save the employee
		employeeService.save(theEmployee);

		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";

	}
}






	// load employee data

	//private List<Employee> theEmployees;

//	@PostConstruct
	//private void loadData() {

		// create employees
	//	Employee emp1 = new Employee("Leslie", "Andrews", "leslie@luv2code.com");
	//	Employee emp2 = new Employee("Emma", "Baumgarten", "emma@luv2code.com");
	//	Employee emp3 = new Employee("Avani", "Gupta", "avani@luv2code.com");

		// create the list
	//	theEmployees = new ArrayList<>();

		// add to the list
	//	theEmployees.add(emp1);
	//	theEmployees.add(emp2);
	//	theEmployees.add(emp3);
	//}

	// add mapping for "/list"











