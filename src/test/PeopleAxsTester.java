package test;

import java.time.LocalDate;
import java.util.Date;

import axs.PeopleAxs;
import biz.Person;

class PeopleAxsTester {
	public static void main(String args[]) {
		System.out.println(mergeTest()?"OK :-)":"KO :-(");
	}
	public static boolean mergeTest() {
		PeopleAxs pax=PeopleAxs.getUniqueInstance();
		long lind=new Date().getTime();
		Person p=new Person();
		p.setUserName("joe"+lind);
		p.setEmail("joe.dalton."+lind+"@desperados.com");
		p.setPassword("JoeDalton1");
		p.setFirstName("Joe");
		p.setLastName("Dalton");
		p.setBirthDate(LocalDate.of(1970, 1, 3));
		if(pax.add(p)) {
			try {
				Thread.sleep(20000);
				p.setEmail("william.dalton."+lind+"@desperados.com");
				p.setPassword("william1");
				p.setFirstName("William");
				p.setLastName("Daltonian");
				p.setBirthDate(LocalDate.of(1971, 2, 4));
				return pax.update(p);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	public static boolean addTest() {
		PeopleAxs pax=PeopleAxs.getUniqueInstance();
		Person p;
		boolean ok=true;
		long lind=new Date().getTime();
		for(int i=0;i<5;i++,lind++) {
			try {
				System.out.println("----------");
				System.out.println("lind="+lind);
				Thread.sleep(1000);
				p=new Person();
				p.setUserName("joe"+lind);
				p.setEmail("joe.dalton."+lind+"@desperados.com");
				p.setPassword("JoeDalton1");
				p.setFirstName("Joe");
				p.setLastName("Dalton");
				p.setBirthDate(LocalDate.of(1970, 12, 3));
				ok=ok && pax.add(p);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ok;
	}
}
