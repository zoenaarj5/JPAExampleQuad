package vbn;

import biz.Person;

public class SignInBean {
	private Person LoggedPerson;
	private String inputLogin,inputEmail,inputPassword;
	public Person getLoggedPerson() {
		return LoggedPerson;
	}
	public void setLoggedPerson(Person loggedPerson) {
		LoggedPerson = loggedPerson;
	}
	public String getInputLogin() {
		return inputLogin;
	}
	public void setInputLogin(String inputLogin) {
		this.inputLogin = inputLogin;
	}
	public String getInputEmail() {
		return inputEmail;
	}
	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}
	public String getInputPassword() {
		return inputPassword;
	}
	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	public void signIn() {
		
	}
}
