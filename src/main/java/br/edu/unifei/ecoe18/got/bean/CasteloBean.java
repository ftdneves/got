package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CasteloDAO;
import br.edu.unifei.ecoe18.got.modelo.Castelo;
import lombok.Data;

@Data
@Named
@RequestScoped
public class CasteloBean implements Serializable{
	private Castelo castelo = new Castelo();
	private CasteloDAO casteloDAO = new CasteloDAO();
	
	public String inserir() {
		try {
			casteloDAO.create(castelo);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		castelo=casteloDAO.find(castelo.getNome());
		if(castelo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		castelo=casteloDAO.find(castelo.getNome());
		if(castelo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		castelo=casteloDAO.find(castelo.getNome());
		if(castelo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		casteloDAO.update(castelo);
		return "/main-page";
	}
	
	public String excluir() {
		casteloDAO.deleteKey(castelo.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}
}
