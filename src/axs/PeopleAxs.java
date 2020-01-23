package axs;

import java.util.Set;

import biz.Application;
import biz.Person;

public class PeopleAxs implements DataAxs<Person,Long>{
	private static PeopleAxs uniqueInstance=new PeopleAxs();
	private PeopleAxs() {
		super();
	}
	@Override
	public Set<Person> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person fetch(Long id) {
		return entityManager.find(Person.class, id);
	}

	@Override
	public boolean add(Person person) {
		try {
			transaction.begin();
			entityManager.persist(person);
			transaction.commit();
			System.out.println("===========");
			System.out.println("Just added "+person.getUserName()+", email="+person.getEmail());
			return true;
		}catch(Exception e) {
			System.out.println("**********");
			System.out.println("Failed to add "+person.getUserName()+", email="+person.getEmail());
			e.printStackTrace();
			return false;
		}
	}
	public static PeopleAxs getUniqueInstance() {
		return uniqueInstance;
	}
	@Override
	public boolean delete(Long id) {
		try {
			transaction.begin();
			entityManager.remove(entityManager.find(Person.class, id));
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(Person p) {
		try {
			transaction.begin();
			entityManager.merge(p);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
