package com.espark.adarsh;

import com.espark.adarsh.service.LifeCycleBean;
import com.espark.adarsh.configuration.ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ApplicationMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new
				AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		LifeCycleBean lifeCycleBean = applicationContext.getBean(LifeCycleBean.class);
		log.info(lifeCycleBean.getName());
	}

}
