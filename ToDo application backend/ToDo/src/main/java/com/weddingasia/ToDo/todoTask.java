package com.weddingasia.ToDo;

import java.util.List;

public interface todoTask {
	
	public todoBean addTask(todoBean bean);
	
	public void editTask(todoBean bean);
	
	public List<todoBean> getAllTask();

}
