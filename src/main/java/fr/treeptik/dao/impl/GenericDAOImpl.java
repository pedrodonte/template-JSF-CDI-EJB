package fr.treeptik.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Employe;

public class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {

	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {

		this.type = type;
	}

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Override
	public T register(T entite) throws DAOException {
		 log.info("Registering " + entite.toString());
	        em.persist(entite);
		return entite;
	}

	@Override
	public T update(T entite) throws DAOException {
		log.info("Registering " + entite.toString());
		em.merge(entite);
		return entite;
	}

	@Override
	public void removeById(Employe employe) throws DAOException {
		log.info("error remove");
		Query query = em.createQuery("Delete from " + type.getSimpleName() + " t where t.id = :id");
		query.setParameter("id", employe.getId());
		query.executeUpdate();
		
	}

	@Override
	public List<T> findAll() throws DAOException {
		log.info("error findAll");
		return em.createQuery("select o from " + type.getSimpleName() + " o ", type).getResultList();
	}

	@Override
	public T findById(PK id) throws DAOException {
		log.info("error findById");
		return em.find(type, id);
	}

}
