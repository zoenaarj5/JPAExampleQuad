package biz;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Table @Entity
public class Job {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;

	@Column(name="OPENING_DATE")
	private LocalDate openingDate;
	
	private LocalDate deadline;
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID",insertable=false,updatable=false)
	private Company company;

	@OneToMany(cascade=CascadeType.ALL)
	private Set<Asset> requiredAssets;
	@Transient
	private boolean open;
	public Company getCompany() {
		return company;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public String getDescription() {
		return description;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public Set<Asset> getRequiredAssets() {
		return requiredAssets;
	}
	public boolean isOpen() {
		return open;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public void setRequiredAssets(Set<Asset> requiredAssets) {
		this.requiredAssets = requiredAssets;
	}
}
