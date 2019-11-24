package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.PlebeuDAO;
import br.edu.unifei.ecoe18.got.modelo.Plebeu;
import lombok.Data;

@Data
@Named
@RequestScoped
public class PlebeuBean implements Serializable{
	private Plebeu plebeu = new Plebeu();
	private PlebeuDAO plebeuDAO = new PlebeuDAO();
	
	public String inserir() {
		try {
			plebeuDAO.create(plebeu);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		plebeu=plebeuDAO.find(plebeu.getNumber());
		if(plebeu==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		plebeu=plebeuDAO.find(plebeu.getNumber());
		if(plebeu==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		plebeu=plebeuDAO.find(plebeu.getNumber());
		if(plebeu==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		plebeuDAO.update(plebeu);
		return "/main-page";
	}
	
	public String excluir() {
		plebeuDAO.deleteKey(plebeu.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
	
}
