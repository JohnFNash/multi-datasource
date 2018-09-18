package com.johnfnash.learn.pro.dashboardserver.service.env;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.johnfnash.learn.pro.dashboardserver.core.DataSource;
import com.johnfnash.learn.pro.dashboardserver.dao.env.CompanyMapper;
import com.johnfnash.learn.pro.dashboardserver.domain.Company;

@Service("companyService")
//@DataSource("dataSourceEnv") //没有设置时，会使用上一次切换到的 datasource
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Company> getAll() {
		return companyMapper.getAll();
	}

}
