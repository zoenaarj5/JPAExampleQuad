package axs;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public interface DataAxs<T,K> {
	final EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jobzapp");
	@PersistenceContext(unitName="JPAExampleQuad")
	final EntityManager entityManager=entityManagerFactory.createEntityManager();
	final EntityTransaction transaction=entityManager.getTransaction();
	Set<T> fetchAll();
	T fetch(K id);
	boolean add(T t);
}
