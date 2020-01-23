package biz;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table @Entity
public class Experience extends Asset {
	@ManyToOne
	@JoinColumn(name="company_id",insertable=false,updatable=false)
	private Company company;
	@ManyToOne
	@JoinColumn(name="person_id",insertable=false,updatable=false)
	private Person person;
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Task> tasks;
	private LocalDate startingDate;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public LocalDate getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}
	private LocalDate endingDate;
}
