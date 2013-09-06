package fr.treeptik.dao.impl;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;

@Stateless
public class EmployeDAOImpl implements EmployeDAO {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;


    @Override
	public void register(Employe employe) throws Exception {
        log.info("Registering " + employe.getNom());
        em.persist(employe);
    }
}
