package co.grandcircus.capstone6;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private Date dueDate;
	private boolean isComplete;
	
	@ManyToOne
	private Users user;
	
	public Tasks() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getisComplete() {
		return isComplete;
	}

	public void setisComplete(boolean complete) {
		this.isComplete = complete;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
}
