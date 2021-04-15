/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.spring.annotation;
/*
 * {@inheritDoc}
*/

/**
 * @Product : AnnotationProcessor provide implementation of the specification
 *                    provided for the ...    
 */


import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 12:05 PM
 * @see
 */
@Slf4j
@Component(value = "annotationProcessor")
public class AnnotationProcessor implements BeanPostProcessor, ApplicationContextAware {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.trace("postProcessBeforeInitialization() " + bean.getClass().getCanonicalName() + "  " + beanName);
        final Class clazz = bean.getClass();
        final Annotation[] classAnnotations = clazz.getAnnotations();

        /* FIELD LEVEL ANNOTATION */
        final Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            final Annotation[] fieldDeclaredAnnotations = field.getDeclaredAnnotations();
            for (Annotation fieldAnnotation : fieldDeclaredAnnotations) {
                if (fieldAnnotation instanceof ClassLogger) {
                    try {
                        final ClassLogger classLogger = (ClassLogger) fieldAnnotation;
                        final Class className = classLogger.className();
                        field.setAccessible(true);
                        field.set(bean, LoggerFactory.getLogger(className));
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }
            }
        }

        /* METHOD LEVEL ANNOTATION */
        for (Annotation annotationClassLevel : classAnnotations) {
            if (annotationClassLevel instanceof RequiredInjection) {
                final Method[] methods = bean.getClass().getMethods();
                for (Method method : methods) {
                    final Annotation[] methodAnnotations = method.getAnnotations();
                    for (Annotation methodAnnotation : methodAnnotations) {
                        try {
                            if (method.getParameterTypes().length == 1) {
                                final Map map = applicationContext.getBeansWithAnnotation(ApplicationBean.class);
                                method.invoke(bean, map);
                            } else {
                                final BeanList beanList = method.getAnnotation(BeanList.class);
                                final Class[] beanClass = beanList.beanList();
                                for (Class beanClassAnnotation : beanClass) {
                                    final ApplicationBean applicationBean = (ApplicationBean) beanClassAnnotation.getAnnotation(ApplicationBean.class);
                                    final Object object = applicationContext.getBean(beanClassAnnotation);
                                    method.invoke(bean, new Object[]{applicationBean.name(), object});
                                }
                            }
                        } catch (Exception e) {
                            log.error(e.getMessage());
                        }
                    }
                }
            }
        }

        /* CONSTRUCTOR ANNOTATION */
        try {
            final Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                final Annotation[] constructorAnnotations = constructor.getDeclaredAnnotations();
                for (Annotation annotation : constructorAnnotations) {
                    if (annotation instanceof ConstructorInjector) {
                        final ConstructorInjector constructorInjector = (ConstructorInjector) annotation;
                        final String value = constructorInjector.data();
                        final Field field = clazz.getDeclaredField("msgText");
                        field.setAccessible(true);
                        field.set(bean, value);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return bean;
    }

    private void classLevelAnnotation(final Class className, final Object bean, final Annotation annotation) {

    }

    private void constructorLevelAnnotation(final Class className, final Object bean, final Annotation annotation) {

    }

    private void fieldLevelAnnotation(final Class className, final Object bean, final Annotation annotation) {

    }

    private void methodLevelAnnotation(final Class className, final Object bean, final Annotation annotation) {

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.trace("postProcessAfterInitialization() " + bean.getClass().getCanonicalName() + "  " + beanName);
        return bean;
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
