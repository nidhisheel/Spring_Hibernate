package com.sheel.practice;

import java.time.LocalDateTime;

public class MyProtoTypeBean {
	private String dateTimestring=LocalDateTime.now().toString();
	public String getDateTime()
	{
		return dateTimestring;
	}

}
