package com.todoApp.dao.response;

import java.util.Date;

public interface IListUserTaskDto {
	
	public String getName();
	
	public String getEmail();
	
	public String getTitle();
	
	public String getDiscription();
	
	public 	Date getStartDate();
	
	public Date getEndDate();
	
	public String getStatus();

}
