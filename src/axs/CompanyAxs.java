package axs;

import java.util.Set;

import biz.Application;
import biz.Company;
import biz.Person;

public class CompanyAxs implements DataAxs<Company, Long> {
	private CompanyAxs uniqueInstance=new CompanyAxs();
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
	public Set<Company> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public CompanyAxs getUniqueInstance() {
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

}
