package fr.treeptik.service.impl;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@Stateless
public class EmployeServiceImpl implements EmployeService {

    @Inject
    private Logger log;

    @Inject
    private EmployeDAO dao;
    
    @Override
	public void register(Employe employe) throws Exception {
        log.info("Registering " + employe.getNom());
        dao.register(employe);
    }
}
