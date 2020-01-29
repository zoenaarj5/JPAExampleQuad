package axs;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import biz.Application;
import mtc.ApplicationMatcher;

public class ApplicationAxs implements DataAxs<Application,Long,ApplicationMatcher> {
	private static ApplicationAxs uniqueInstance=new ApplicationAxs() ;
private ApplicationAxs() {
	super();
}
	@Override
	public List<Application> fetchAll() {
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
	@Override
	public List<Application> fetchBy(Map<ApplicationMatcher, Object> criteria) {
		final CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Application> cq=builder.createQuery(Application.class);
		final Root<Application> root=cq.from(Application.class);
		criteria.entrySet().forEach((es)->{
			ApplicationMatcher matcher=es.getKey();
			Object value=es.getValue();
//			cq.where(builder.equal(root.get("userName"), (String)value));
			switch(matcher) {
			
			}
		});
		List<Application> rsList=entityManager.createQuery(cq).getResultList();
		return rsList;
	}
}
