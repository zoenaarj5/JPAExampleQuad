package axs;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public interface DataAxs<T,K,M> {
	final String PERSISTENCE_UNIT_NAME="JPAExampleQuad";
	final EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	@PersistenceContext(unitName=PERSISTENCE_UNIT_NAME)
	final EntityManager entityManager=entityManagerFactory.createEntityManager();
	final EntityTransaction transaction=entityManager.getTransaction();
	List<T> fetchAll();
	List<T> fetchBy(Map<M,Object> criteria);
	T fetch(K id);
	boolean add(T t);
	boolean update(T t);
	boolean delete(K id);
}
