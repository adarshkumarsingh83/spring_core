# Instantiate of Bean Object 
* Population of Properties  
* call setBeanName-> BeanNameAware
* call setBeanFactory-> BeanFactoryAware 
* call setApplicationContext-> ApplicationContextAware
* call postProcessBeforeInitialization -> BeanPostProcessor
* call afterPropertiesSet -> InitializingBean 
* call custom init() 
* call postProcessAfterInitialization -> BeanPostProcessor 
* Bean is ready to use

....
....

* ContainerShutDown 
* call destroy()-> DisposableBean 
* call custom destroy() 

1. Within IoC container, a spring bean is created using class constructor.
2. Now the dependency injection is performed using setter method.
3. Once the dependency injection is completed, BeanNameAware.setBeanName() is called. It sets the name of bean in the bean factory that created this bean.
4. Now BeanClassLoaderAware.setBeanClassLoader() is called that supplies the bean class loader to a bean instance.
5. Now BeanFactoryAware.setBeanFactory() is called that provides the owning factory to a bean instance.
6. Now the IoC container calls BeanPostProcessor.postProcessBeforeInitialization on the bean. Using this method a wrapper can be applied on original bean.
7. Now the method annotated with @PostConstruct is called.
8. After @PostConstruct, the method InitializingBean.afterPropertiesSet() is called.
9. Now the method specified by init-method attribute of bean in XML configuration is called.
10. And then BeanPostProcessor.postProcessAfterInitialization() is called. It can also be used to apply wrapper on original bean.
11. Now the bean instance is ready to be used. Perform the task using the bean.
12. Now when the ApplicationContext shuts down such as by using registerShutdownHook() then the method annotated with @PreDestroy is called.
13. After that DisposableBean.destroy() method is called on the bean.
14. Now the method specified by destroy-method attribute of bean in XML configuration is called.
15. Before garbage collection, finalize() method of Object is called.