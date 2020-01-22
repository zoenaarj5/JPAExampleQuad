package test;


import java.time.LocalDate;
import axs.PeopleAxs;
import biz.Person;

class PeopleAxTester {
	public static void main(String args[]) {
		System.out.println(addTest()?"OK :-)":"KO :-(");
	}
	private static boolean addTest() {
		PeopleAxs pax=PeopleAxs.getUniqueInstance();
		Person p=new Person();
		p.setUserName("joe");
		p.setEmail("joe.dalton@desperados.com");
		p.setPassword("JoeDalton1");
		p.setFirstName("Joe");
		p.setLastName("Dalton");
		p.setBirthDate(LocalDate.of(1850,4,1));
		return pax.add(p);
	}

}
