package biz;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Application {
	@Id
	@GeneratedValue
	private long id;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name="applicant_id")
	private Person applicant;
	private Job job;
	@Column(name="receiving_date")
	private LocalDate receivingDate;
	@Column(name="signing_date")
	private boolean acceptanceDate;
	@Column(name="signing_date")
	private boolean signingDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Person getApplicant() {
		return applicant;
	}
	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public LocalDate getReceivingDate() {
		return receivingDate;
	}
	public void setReceivingDate(LocalDate receivingDate) {
		this.receivingDate = receivingDate;
	}
	public boolean isAcceptanceDate() {
		return acceptanceDate;
	}
	public void setAcceptanceDate(boolean acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	public boolean isSigningDate() {
		return signingDate;
	}
	public void setSigningDate(boolean signingDate) {
		this.signingDate = signingDate;
	}
}
