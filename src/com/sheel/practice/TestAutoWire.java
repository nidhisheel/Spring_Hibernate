package com.sheel.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWire {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
		EmployeeBean e1=(EmployeeBean)context.getBean("employee");
		EmployeeBean e2=(EmployeeBean)context.getBean("employee");
		System.out.println(e1.getFullName());
		System.out.println(e2.getFullName());
		Student s1=(Student)context.getBean("student");
		Subject sub=new Subject();
		s1.setSubject(sub);
		Student s2=(Student)context.getBean("student");
		Subject s3=(Subject)context.getBean("sub");
		System.out.println(s3.getStudent());
		
				
		
		EmployeeBean employee=(EmployeeBean) context.getBean("employee");
		System.out.println("Full Name"+employee.getFullName());
		DepartmentBean departmentBean=(DepartmentBean)context.getBean("departmentBean");
		System.out.println("--"+employee.getDepartmentBean().getName());
	}
	
	

}
