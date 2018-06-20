package com.weddingasia.ToDo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class todoBean {

	private int taskId;
	private String taskName;
	private String isDone;
	private String createdAt;
	private String doneAt;
	
	public todoBean() {
		super();
	}
	
	public todoBean(int taskId, String taskName, String isDone, String createdAt, String doneAt) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.isDone = isDone;
		this.createdAt = createdAt;
		this.doneAt = doneAt;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String isDone() {
		return isDone;
	}

	public void setDone(String isDone) {
		this.isDone = isDone;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDoneAt() {
		return doneAt;
	}

	public void setDoneAt(String doneAt) {
		this.doneAt = doneAt;
	}
}
