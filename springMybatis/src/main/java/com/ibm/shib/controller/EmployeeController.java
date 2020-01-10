package com.ibm.shib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.shib.dao.EmployeeMapper;
import com.ibm.shib.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeMapper employeeMapper;
	private static final String EMPLOYEE = "Employee";
	private static final String EMPLOYEELIST = "ListEmployees";
	
	@RequestMapping("/")
	public String showListOfEmployees(Model model){
		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
		return EMPLOYEELIST;
	}
	
	@RequestMapping("/showFormForAdd")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("Employee");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping("/saveProcess")
	public String saveProcess(@ModelAttribute("employee") Employee employee) {
		System.out.println(employee);
		if(employee.getEmpId() == null) {
			employeeMapper.saveEmployee(employee);
		} else {
			employeeMapper.updateEmployee(employee);
		}
		return "redirect:/";
		
	}
	
	@RequestMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam int empId) {
		
		System.out.println("Employee id for delete :" +empId);
		employeeMapper.deleteEmployee(empId);
		return "redirect:/";		
	}
	
	@RequestMapping("/displayUpdateForm")
	public ModelAndView updateEmployee(@RequestParam int empId) {
		System.out.println("update employee: "+empId);
		ModelAndView mav = new ModelAndView("Employee");
		Employee employee = employeeMapper.findByEmployeeId(empId);
		mav.addObject(employee);
		return mav;
	}
	
	/*@RequestMapping("/")
	public String index() {
		System.out.println(employeeMapper.getAllEmployees());
		return "list-employees";
	}*/

}
