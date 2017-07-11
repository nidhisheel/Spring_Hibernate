package com.sheel.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;



public class MySingleTonBean {
	@Autowired
	MyProtoTypeBean prototypeBean;
	
		public void showMessage()
	{
		
		System.out.println("Hi, the time is "+prototypeBean.getDateTime());
	}
		
		
		/*@Lookup
		public MyProtoTypeBean getPrototypeBean()
		{
			return null;
		}
*/
}
