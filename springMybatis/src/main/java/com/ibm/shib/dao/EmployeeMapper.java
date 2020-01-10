package com.ibm.shib.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ibm.shib.entity.Employee;
import com.ibm.shib.util.MybatisUtil;

@Repository
public class EmployeeMapper {
	
	public List<Employee> getAllEmployees(){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
		List<Employee> employeeList = session.selectList("getAllEmployees");
		session.commit();
		session.close();
		return employeeList;
	}
	
	public void saveEmployee(Employee employee) {
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertEmployee", employee);
		session.commit();
		session.close();
		
	}
	
	public void deleteEmployee(int empId) {
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteEmployee", empId);
		session.commit();
		session.close();
	}
	
	public Employee findByEmployeeId(int empId) {
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
		Employee employee = session.selectOne("findByempId", empId);
		session.commit();
		session.close();
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
		session.delete("updateEmployee", employee);
		session.commit();
		session.close();
	}
	

}
