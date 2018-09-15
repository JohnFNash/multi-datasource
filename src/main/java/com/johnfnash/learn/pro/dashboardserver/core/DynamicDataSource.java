package com.johnfnash.learn.pro.dashboardserver.core;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

// ��չSpring��AbstractRoutingDataSource�����࣬ʵ�ֶ�̬����Դ
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// ���Զ����λ�û�ȡ����Դ��ʶ
		return DynamicDataSourceHolder.getDatasource();
	}

}
