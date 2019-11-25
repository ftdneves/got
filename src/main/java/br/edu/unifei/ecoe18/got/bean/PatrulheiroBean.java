package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.PatrulheiroDAO;
import br.edu.unifei.ecoe18.got.modelo.Patrulheiro;
import lombok.Data;

@Data
@Named
@RequestScoped
public class PatrulheiroBean implements Serializable{
	private Patrulheiro patrulheiro = new Patrulheiro();
	private PatrulheiroDAO patrulheiroDAO = new PatrulheiroDAO();
	
	public String inserir() {
		try {
			patrulheiroDAO.create(patrulheiro);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		patrulheiro=patrulheiroDAO.find(patrulheiro.getNumber());
		if(patrulheiro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		patrulheiro=patrulheiroDAO.find(patrulheiro.getNumber());
		if(patrulheiro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		patrulheiro=patrulheiroDAO.find(patrulheiro.getNumber());
		if(patrulheiro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		patrulheiroDAO.update(patrulheiro);
		return "/main-page";
	}
	
	public String excluir() {
		patrulheiroDAO.deleteKey(patrulheiro.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	

}
