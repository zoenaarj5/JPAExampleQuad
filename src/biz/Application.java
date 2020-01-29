package biz;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Table @Entity
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	@ManyToOne
	@JoinColumn(name="APPLICANT_ID",insertable=false,updatable=false)
	private Person applicant;
	@ManyToOne
	@JoinColumn(name="JOB_ID",insertable=false,updatable=false)
	private Job job;
	@Column(name="SENDING_DATE")
	private LocalDateTime sendingDate;
	@Column(name="RECEIVING_DATE")
	private LocalDateTime receivingDate;
	@Column(name="ACCEPTANCE_DATE")
	private LocalDateTime acceptanceDate;
	@Column(name="SIGNING_DATE")
	private LocalDateTime signingDate;
	@Transient
	private boolean sent,received,accepted,signed;
	public LocalDateTime getAcceptanceDate() {
		return acceptanceDate;
	}
	public Person getApplicant() {
		return applicant;
	}
	public long getId() {
		return id;
	}
	public Job getJob() {
		return job;
	}
	public LocalDateTime getReceivingDate() {
		return receivingDate;
	}
	public LocalDateTime getSendingDate() {
		return sendingDate;
	}
	public LocalDateTime getSigningDate() {
		return signingDate;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public boolean isReceived() {
		return received;
	}
	public boolean isSent() {
		return sent;
	}
	public boolean isSigned() {
		return signed;
	}
	public void setAcceptanceDate(LocalDateTime acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
		this.accepted=acceptanceDate!=null;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
		this.acceptanceDate=accepted?LocalDateTime.now():null;
	}
	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public void setReceived(boolean received) {
		this.received = received;
		this.receivingDate=received?LocalDateTime.now():null;
	}
	public void setReceivingDate(LocalDateTime receivingDate) {
		this.receivingDate = receivingDate;
		this.received=receivingDate!=null;
	}
	public void setSendingDate(LocalDateTime sendingDate) {
		this.sendingDate = sendingDate;
		this.sent=sendingDate!=null;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
		this.sendingDate=sent?LocalDateTime.now():null;
	}
	public void setSigned(boolean signed) {
		this.signed = signed;
		this.signingDate=signed?LocalDateTime.now():null;
	}
	public void setSigningDate(LocalDateTime signingDate) {
		this.signingDate = signingDate;
		this.signed=signingDate!=null;
	}
}
