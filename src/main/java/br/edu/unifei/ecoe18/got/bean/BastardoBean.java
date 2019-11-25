package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.BastardoDAO;
import br.edu.unifei.ecoe18.got.modelo.Bastardo;
import lombok.Data;

@Data
@Named
@RequestScoped
public class BastardoBean implements Serializable{
	private static final long serialVersionUID = -246912369246487022L;
	private Bastardo bastardo = new Bastardo();
	private BastardoDAO bastardoDAO = new BastardoDAO();
	
	public String inserir() {
		try {
			bastardoDAO.create(bastardo);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		bastardo=bastardoDAO.find(bastardo.getNumber());
		if(bastardo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		bastardo=bastardoDAO.find(bastardo.getNumber());
		if(bastardo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		bastardo=bastardoDAO.find(bastardo.getNumber());
		if(bastardo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		bastardoDAO.update(bastardo);
		return "/main-page";
	}
	
	public String excluir() {
		bastardoDAO.deleteKey(bastardo.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
