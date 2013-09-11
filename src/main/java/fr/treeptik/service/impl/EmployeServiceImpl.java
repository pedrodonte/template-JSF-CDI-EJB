package fr.treeptik.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;


@Stateless
public class EmployeServiceImpl implements EmployeService {

    @Inject
    private Logger log;

    @Inject
    private EmployeDAO employeDAO;
    
    @Override
	public Employe register(Employe employe) throws ServiceException {
        try {
        	log.info("Registering " + employe.getLabel());
			employeDAO.register(employe);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
        return employe;
    }

	@Override
	public Employe update(Employe employe) throws ServiceException {
		try {
			employeDAO.update(employe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return employe;
	}

	@Override
	public void removeById(Employe employe) throws ServiceException {
		try {
			employeDAO.removeById(employe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<Employe> findAll() throws ServiceException {
		List<Employe> employes = new ArrayList<>();
		try {
			employes = employeDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return employes;
	}

	@Override
	public Employe findById(Integer id) throws ServiceException {
		Employe employe = null;
		try {
			employe = employeDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return employe;
	}
}
