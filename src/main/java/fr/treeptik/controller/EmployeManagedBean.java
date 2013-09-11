package fr.treeptik.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;
import fr.treeptik.wsimport.WeatherSoap;

@ManagedBean(name = "employeMB")
@SessionScoped
public class EmployeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private EmployeService employeService;

	private Employe employe;

	private ListDataModel<Employe> dataModel = new ListDataModel<>();
	
	
	@PostConstruct
	public void init() {
		setEmploye(new Employe());
	}

	public void register() throws Exception {
		try {
			employeService.register(getEmploye());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public String updateEmployee() throws Exception {

		employe = dataModel.getRowData();

		return "create";

	}

	public String deleteEmploye() throws Exception {

		employe = dataModel.getRowData();
		employeService.removeById(employe);

		return "list";
	}

	public String listEmploye() {
		return "list";
	}

	public ListDataModel<Employe> getEmployeList() throws Exception {
		dataModel = new ListDataModel<Employe>(employeService.findAll());
		return dataModel;

	}
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public EmployeService getReservationService() {
		return employeService;
	}

	public void setReservationService(EmployeService employeService) {
		this.employeService = employeService;
	}

	

}
