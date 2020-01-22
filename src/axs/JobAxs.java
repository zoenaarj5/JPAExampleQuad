package axs;

import java.util.Set;

import biz.Job;

public class JobAxs implements DataAxs<Job,Long> {
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
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Job fetch(Long id) {
		return entityManager.find(Job.class, id);
	}
	@Override
	public Set<Job> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
