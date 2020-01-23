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
		try {
			transaction.begin();
			entityManager.persist(application);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static ApplicationAxs getUniqueInstance() {
		return uniqueInstance;
	}
	@Override
	public boolean delete(Long id) {
		try {
			transaction.begin();
			entityManager.remove(entityManager.find(Application.class, id));
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(Application ap) {
		try {
			transaction.begin();
			entityManager.merge(ap);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
