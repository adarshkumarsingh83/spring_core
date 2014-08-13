package com.adarsh.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ShutdownHookBean implements BeanFactoryAware, Runnable {

  public static final Logger LOGGER = LoggerFactory.getLogger(ShutdownHookBean.class);

  private ConfigurableListableBeanFactory beanFactory;

  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
      if (beanFactory instanceof DefaultListableBeanFactory) {
          this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
          Runtime.getRuntime().addShutdownHook(new Thread(this));
      }
  }

  public void run() {
      if (this.beanFactory != null) {
          LOGGER.info("Destroying singletons.");
          this.beanFactory.destroySingletons();
      }
  }
}
