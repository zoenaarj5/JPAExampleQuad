package axs;

import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import biz.Person;
import mtc.PersonMatcher;

public class PeopleAxs implements DataAxs<Person,Long,PersonMatcher>{
	private static PeopleAxs uniqueInstance=new PeopleAxs();
	private PeopleAxs() {
		super();
	}
	@Override
	public List<Person> fetchAll() {
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
	@Override
	public List<Person> fetchBy(Map<PersonMatcher, Object> criteria) {
		final CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Person> cq=builder.createQuery(Person.class);
		final Root<Person> root=cq.from(Person.class);
		criteria.entrySet().forEach((es)->{
			PersonMatcher matcher=es.getKey();
			Object value=es.getValue();
			switch(matcher) {
			case EMAIL:
				cq.where(builder.equal(root.get("email"),(String)value));
				break;
			case FIRST_NAME:
				cq.where(builder.equal(root.get("firstName"),(String)value));
				break;
			case ID:
				cq.where(builder.equal(root.get("id"), Long.valueOf(value.toString())));
				break;
			case LAST_NAME:
				cq.where(builder.equal(root.get("lastName"), (String)value));
				break;
			case PASSWORD:
				cq.where(builder.equal(root.get("password"), (String)value));
				break;
			case USER_NAME:
				cq.where(builder.equal(root.get("userName"), (String)value));
				break;
			default:
				break;
			
			}
		});
		List<Person> rsList=entityManager.createQuery(cq).getResultList();
		return rsList;
	}
}
