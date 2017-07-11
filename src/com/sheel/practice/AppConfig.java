package com.sheel.practice;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



@Configuration
@ComponentScan(basePackageClasses =MySingleTonBean.class)

public class AppConfig {
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public MyProtoTypeBean prototypeBean()
	{
	return new MyProtoTypeBean();	
	}
	
	@Bean
	public MySingleTonBean singleTonBean()
	{
		return new MySingleTonBean();
	}
	public static void main(String[] args) throws InterruptedException {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		MySingleTonBean bean=context.getBean(MySingleTonBean.class);
		bean.showMessage();
		Thread.sleep(1000);
		bean=context.getBean(MySingleTonBean.class);

		bean.showMessage();
		
	}
}
