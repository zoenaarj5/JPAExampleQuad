package axs;

import java.util.Set;

import biz.Company;

public class CompanyAxs implements DataAxs<Company, Long> {
	private CompanyAxs uniqueInstance=new CompanyAxs();
	private CompanyAxs() {
		super();
	}
	@Override
	public boolean add(Company t) {
		// TODO Auto-generated method stub
		return false;
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

}
