package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.WightDAO;
import br.edu.unifei.ecoe18.got.modelo.Wight;
import lombok.Data;

@Data
@Named
@RequestScoped
public class WightBean implements Serializable{
	private static final long serialVersionUID = 9163864015895045766L;
	private Wight wight = new Wight();
	private WightDAO wightDAO = new WightDAO();
	
	public String inserir() {
		try {
			wightDAO.create(wight);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		wight=wightDAO.find(wight.getNome());
		if(wight==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		wight=wightDAO.find(wight.getNome());
		if(wight==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		wight=wightDAO.find(wight.getNome());
		if(wight==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		wightDAO.update(wight);
		return "/main-page";
	}
	
	public String excluir() {
		wightDAO.deleteKey(wight.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	

}
