package com.johnfnash.learn.pro.dashboardserver.core;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

// ����Դ��̬�л�������
public class DynamicDataSourceInterceptor {

	/**
     * ����Ŀ�귽������ȡ��@DataSourceָ��������Դ��ʶ�����õ��̴߳洢���Ա��л�����Դ
     * 
     * @param point
     * @throws Exception
     */
	public void intercept(JoinPoint point) {
		Class<?> target = point.getTarget().getClass();
		MethodSignature signature = (MethodSignature) point.getSignature();
		resolveDataSource(target, signature.getMethod());
	}
	
	/**
     * ��ȡĿ����󷽷�ע�������ע���е�����Դ��ʶ
     * 
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
    	try {
    		Class<?>[] types = method.getParameterTypes();
    		// Ĭ��ʹ������ע��
    		if(clazz.isAnnotationPresent(DataSource.class)) {
    			DataSource source = clazz.getAnnotation(DataSource.class);
    			DynamicDataSourceHolder.setDataSource(source.value());
    		}
    		
    		 // ����ע����Ը�������ע��
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
            	DataSource source = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
