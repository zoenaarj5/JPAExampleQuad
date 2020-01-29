package axs;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import biz.Job;
import mtc.JobMatcher;

public class JobAxs implements DataAxs<Job,Long,JobMatcher> {
	private static JobAxs uniqueInstance=new JobAxs();
	public static JobAxs getUniqueInstance() {
		return uniqueInstance;
	}
	private JobAxs(){
		super();
	}

	@Override
	public boolean add(Job t) {
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
	public Job fetch(Long id) {
		return entityManager.find(Job.class, id);
	}
	@Override
	public List<Job> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(Long id) {
		try {
			transaction.begin();
			entityManager.remove(entityManager.find(Job.class,id));
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(Job job) {
		try {
			transaction.begin();
			entityManager.merge(job);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Job> fetchBy(Map<JobMatcher, Object> criteria) {
		final CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Job> cq=builder.createQuery(Job.class);
		final Root<Job> root=cq.from(Job.class);
		criteria.entrySet().forEach((es)->{
			JobMatcher matcher=es.getKey();
			Object value=es.getValue();
//			cq.where(builder.equal(root.get("userName"), (String)value));
			switch(matcher) {
			case DEADLINE:
				cq.where(builder.equal(root.get("deadline"), value));
				break;
			case DESCRIPTION:
				cq.where(builder.equal(root.get("description"), value));
				break;
			case NAME:
				cq.where(builder.equal(root.get("name"), value));
				break;
			default:
				break;
			}
		});
		List<Job> rsList=entityManager.createQuery(cq).getResultList();
		return rsList;
	}
}
