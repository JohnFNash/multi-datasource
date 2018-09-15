package com.johnfnash.learn.pro.dashboardserver.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnfnash.learn.pro.dashboardserver.core.DataSource;
import com.johnfnash.learn.pro.dashboardserver.dao.task.StudentMapper;
import com.johnfnash.learn.pro.dashboardserver.domain.Student;

@Service("studentService")
@DataSource("dataSourceTask")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> getAll() {
		return studentMapper.getAll();
	}

}
