package biz;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.hash.Hashing;

@Table @Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Transient
	private int age;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="USER_NAME",unique=true)
	private String userName;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Asset> assets;
	public int getAge() {
		return age;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
		if(birthDate!=null) {
			this.age=Period.between(birthDate, LocalDate.now()).getYears();
		}
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = Hashing.sha512().hashString(password, StandardCharsets.UTF_8).toString();
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
