package axs;

import java.util.Set;

import biz.Application;

public class ApplicationAxs implements DataAxs<Application,Long> {
	private static ApplicationAxs uniqueInstance=new ApplicationAxs() ;
private ApplicationAxs() {
	super();
}
	@Override
	public Set<Application> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application fetch(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Application application) {
		transaction.begin();
		try {
			entityManager.persist(application);
		}catch(Exception e) {
			transaction.rollback();
			return false;
		}
		transaction.commit();
		return true;
	}
	public static ApplicationAxs getUniqueInstance() {
		return uniqueInstance;
	}
}
