package com.johnfnash.learn.pro.dashboardserver.core;

// ��ǰ�߳���ʹ�õ�����Դ��ʶ
public class DynamicDataSourceHolder {

	/** ����Դ��ʶ�������̱߳����У�������̲߳�������Դʱ������� */
	private static final ThreadLocal<String> contextHolder =
			new ThreadLocal<String>();
	
	/**
	 * ��������Դ����
	 * @param dastsource ����Դ����
	 */
	public static void setDataSource(String datasource) {
		contextHolder.set(datasource);
	}

	/**
	 * ��ȡ����Դ����
	 * @return ����Դ����
	 */
	public static String getDatasource() {
		return contextHolder.get();
	}
	
	/**
	 * �����־
	 */
	public static void clearDatasource() {
		contextHolder.remove();
	}
	
}
