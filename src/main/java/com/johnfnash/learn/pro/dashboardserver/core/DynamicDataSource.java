package com.johnfnash.learn.pro.dashboardserver.core;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

// 扩展Spring的AbstractRoutingDataSource抽象类，实现动态数据源
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// 从自定义的位置获取数据源标识
		return DynamicDataSourceHolder.getDatasource();
	}

}
