package axs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import biz.Company;
import biz.Person;
import mtc.CompanyMatcher;

public class CompanyAxs implements DataAxs<Company, Long,CompanyMatcher> {
	private  static CompanyAxs uniqueInstance=new CompanyAxs();
	private CompanyAxs() {
		super();
	}
	@Override
	public boolean add(Company t) {
		try {
			transaction.begin();
			entityManager.persist(t);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Company fetch(Long id) {
		return entityManager.find(Company.class,id);
	}

	@Override
	public List<Company> fetchAll() {
//		Map<CompanyMatcher,Object> criteria=new HashMap<>();
		final CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Company> cq=builder.createQuery(Company.class);
		List<Company> rsList=entityManager.createQuery(cq).getResultList();
		return rsList;
	}
	public static CompanyAxs getUniqueInstance() {
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
	public boolean update(Company c) {
		try {
			transaction.begin();
			entityManager.merge(c);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Company> fetchBy(Map<CompanyMatcher, Object> criteria) {
		final CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Company> cq=builder.createQuery(Company.class);
		final Root<Company> root=cq.from(Company.class);
		criteria.entrySet().forEach((es)->{
			CompanyMatcher matcher=es.getKey();
			Object value=es.getValue();
//			cq.where(builder.equal(root.get("userName"), (String)value));
			switch(matcher) {
			case AGE:
				cq.where(builder.equal(root.get("age"), value));
				break;
			case DESCRIPTION:
				cq.where(builder.equal(root.get("description"), value));
				break;
			case FOUNDING_DATE:
				cq.where(builder.equal(root.get("foundingDate"), value));
				break;
			case NAME:
				cq.where(builder.equal(root.get("name"), value));
				break;
			default:
				break;
			
			}
		});
		List<Company> rsList=entityManager.createQuery(cq).getResultList();
		return rsList;
	}

}
