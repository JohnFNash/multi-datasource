package com.johnfnash.learn.multidatasource;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.johnfnash.learn.pro.dashboardserver.domain.Student;
import com.johnfnash.learn.pro.dashboardserver.domain.User;
import com.johnfnash.learn.pro.dashboardserver.service.env.UserService;
import com.johnfnash.learn.pro.dashboardserver.service.task.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-datasource.xml" })
public class AppTest {
   
	@Autowired
    private UserService userService;
	
	@Autowired
    private StudentService studentService;

	@Test
	public void test() {
		List<Student> students = studentService.getAll();
		for (Student stu : students) {
			System.out.println(stu);
		}
		
		System.out.println("=====================");
		
		List<User> userList = userService.getAll();
		for (User user : userList) {
			System.out.println(user);
		}
		
		System.out.println("=====================");
		
		students = studentService.getAll();
		for (Student stu : students) {
			System.out.println(stu);
		}		
		
	}
	
	@Test
	public void testEnv() {
		List<User> userList = userService.getAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testTask() {
		List<Student> students = studentService.getAll();
		for (Student stu : students) {
			System.out.println(stu);
		}
	}
	
}
