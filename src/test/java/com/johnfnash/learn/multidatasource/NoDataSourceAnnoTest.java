package com.johnfnash.learn.multidatasource;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.johnfnash.learn.pro.dashboardserver.core.DynamicDataSourceHolder;
import com.johnfnash.learn.pro.dashboardserver.domain.Company;
import com.johnfnash.learn.pro.dashboardserver.domain.Student;
import com.johnfnash.learn.pro.dashboardserver.service.env.CompanyService;
import com.johnfnash.learn.pro.dashboardserver.service.task.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-datasource.xml" })
public class NoDataSourceAnnoTest {
   
	@Autowired
    private CompanyService companyService;
	
	@Autowired
    private StudentService studentService;

	@Test
	public void test() {
		List<Student> students = studentService.getAll();
		for (Student stu : students) {
			System.out.println(stu);
		}
		
		System.out.println("=====================");
		
		List<Company> companies = companyService.getAll();
		for (Company comp : companies) {
			System.out.println(comp);
		}
		
		System.out.println("=====================");
		
		students = studentService.getAll();
		for (Student stu : students) {
			System.out.println(stu);
		}		
	}
	
	@Test
	public void testInOwnThread() throws InterruptedException {
		Thread threadA = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "  " + DynamicDataSourceHolder.getDatasource());
				List<Student> students = studentService.getAll();
				for (Student stu : students) {
					System.out.println(stu);
				}
				System.out.println(Thread.currentThread().getName() + "  " + DynamicDataSourceHolder.getDatasource());
			}
		};
		
		Thread threadB = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "  " + DynamicDataSourceHolder.getDatasource());
				List<Company> companies = companyService.getAll();
				for (Company comp : companies) {
					System.out.println(comp);
				}
				System.out.println(Thread.currentThread().getName() + "  " + DynamicDataSourceHolder.getDatasource());
			}
		};
		
		Thread threadC = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "  " + DynamicDataSourceHolder.getDatasource());
				List<Student> students = studentService.getAll();
				for (Student stu : students) {
					System.out.println(stu);
				}
				System.out.println(Thread.currentThread().getName() + "  " + DynamicDataSourceHolder.getDatasource());
			}
		};
		
		threadA.start();
		threadB.start();
		threadC.start();
		
		threadA.join();
		threadB.join();
		threadC.join();
	}
	
}
