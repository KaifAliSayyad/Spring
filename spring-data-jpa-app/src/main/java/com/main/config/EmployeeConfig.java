package com.main.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "employeeEntityMangerFactory",
		basePackages = {"com.main.dao"} ,
		transactionManagerRef = "employeeTransactionManager"
		)
public class EmployeeConfig {
     
	@Autowired
	private Environment environment;
	// datasource
	
	@Bean(name="employeeDataSource")
	@Primary
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("employee.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("employee.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("employee.datasource.username"));
		dataSource.setPassword(environment.getProperty("employee.datasource.password"));
		
		return dataSource;
	}
	
	
	//entityManagerFactory
	@Bean("employeeEntityMangerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFatory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.main.entities");
		
		 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		    bean.setJpaVendorAdapter(vendorAdapter);
		    
		Properties properties = new Properties();
	    properties.setProperty("hibernate.hbm2ddl.auto", "update"); // Change as needed
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

	    bean.setJpaProperties(properties);
		return bean;
	}
	
	
	
	
	
	//platformTransactionManager
	@Primary
	@Bean(name="employeeTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFatory().getObject());
		return manager;
	}
}
