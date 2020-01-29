package biz;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Table @Entity
public class Company {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	private String name;
	private String description;
	@Transient
	private int age;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	@Column(name="FOUNDING_DATE")
	private LocalDate foundingDate;
	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	@Column(name="SUBSCRIPTION_DATE")
	private LocalDate subscriptionDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getFoundingDate() {
		return foundingDate;
	}
	public void setFoundingDate(LocalDate foundingDate) {
		this.foundingDate = foundingDate;
		if(foundingDate!=null) {
			this.age=Period.between(foundingDate, LocalDate.now()).getYears();
		}
	}
}
