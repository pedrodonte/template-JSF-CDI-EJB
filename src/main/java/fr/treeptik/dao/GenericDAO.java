package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Employe;

public interface GenericDAO <T, PK> {

	
	T register(T entite) throws DAOException;
	T update(T entite) throws DAOException;
	void removeById(Employe employe) throws DAOException;
	List<T> findAll() throws DAOException;
	T findById(PK id) throws DAOException;
	
	
}

