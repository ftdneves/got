package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CasteloDAO;
import br.edu.unifei.ecoe18.got.dao.FortalezaDAO;
import br.edu.unifei.ecoe18.got.modelo.Castelo;
import br.edu.unifei.ecoe18.got.modelo.Fortaleza;
import lombok.Data;

@Data
@Named
@RequestScoped
public class FortalezaBean implements Serializable{
	private static final long serialVersionUID = 4155997005924552036L;
	private Fortaleza fortaleza = new Fortaleza();
	private FortalezaDAO fortalezaDAO = new FortalezaDAO();
	
	private CasteloDAO casteloDAO = new CasteloDAO();
	private List<Castelo> castelos = casteloDAO.findAll();
	
	public String inserir() {
		try {
			fortalezaDAO.create(fortaleza);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		fortaleza=fortalezaDAO.find(fortaleza.getNome());
		if(fortaleza==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		fortaleza=fortalezaDAO.find(fortaleza.getNome());
		if(fortaleza==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		fortaleza=fortalezaDAO.find(fortaleza.getNome());
		if(fortaleza==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		fortalezaDAO.update(fortaleza);
		return "/main-page";
	}
	
	public String excluir() {
		fortalezaDAO.deleteKey(fortaleza.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
