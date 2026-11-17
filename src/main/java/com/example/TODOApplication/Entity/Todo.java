package com.example.TODOApplication.Entity;

import jakarta.persistence.*;

// Spring will create a table in DB for this class because we have @Entity annotation for this class
// @Table spring will create a table in DB by the name you specify in here
@Entity
@Table(name="todotable")
public class Todo {
	
	// inform Spring this is my ID
	// GeneratedValue(strategy=GenerationType.AUTO) tells JPA to automatically choose a strategy to generate the primary key value.
	// IDENTITY：使用数据库的自增 ID（例如 MySQL AUTO_INCREMENT）。SEQUENCE：使用数据库的 Sequence 生成 ID（例如 PostgreSQL）。
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String taskContent;
	private String completionStatus;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	public String getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}
	
	

}
