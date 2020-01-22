package axs;

import java.util.Set;

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
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static PeopleAxs getUniqueInstance() {
		return uniqueInstance;
	}
}
