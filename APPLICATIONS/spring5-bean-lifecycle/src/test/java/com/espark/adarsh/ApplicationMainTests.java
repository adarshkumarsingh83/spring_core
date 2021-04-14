package com.espark.adarsh;

import com.espark.adarsh.configuration.ApplicationConfiguration;
import com.espark.adarsh.service.LifeCycleBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class ApplicationMainTests {

    @Autowired
	LifeCycleBean lifeCycleBean;

	@Test
	public void testService() {
		log.info(lifeCycleBean.getName());
	}
}