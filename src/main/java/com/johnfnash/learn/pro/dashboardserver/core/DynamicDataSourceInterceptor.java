package com.johnfnash.learn.pro.dashboardserver.core;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

// 数据源动态切换拦截器
public class DynamicDataSourceInterceptor {

	/**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
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
     * 提取目标对象方法注解和类型注解中的数据源标识
     * 
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
    	try {
    		Class<?>[] types = method.getParameterTypes();
    		// 默认使用类型注解
    		if(clazz.isAnnotationPresent(DataSource.class)) {
    			DataSource source = clazz.getAnnotation(DataSource.class);
    			DynamicDataSourceHolder.setDataSource(source.value());
    		}
    		
    		 // 方法注解可以覆盖类型注解
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
