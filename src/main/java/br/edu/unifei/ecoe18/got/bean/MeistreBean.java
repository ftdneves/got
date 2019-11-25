package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.MeistreDAO;
import br.edu.unifei.ecoe18.got.modelo.Meistre;
import br.edu.unifei.ecoe18.got.modelo.MetaisElosColarEnum;
import lombok.Data;

@Data
@Named
@RequestScoped
public class MeistreBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7211738623840860339L;
	private Meistre meistre = new Meistre();
	private MeistreDAO meistreDAO = new MeistreDAO();

	private MetaisElosColarEnum[] elos = MetaisElosColarEnum.values();
	
	public String inserir() {
		try {
			meistreDAO.create(meistre);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		meistre=meistreDAO.find(meistre.getNumber());
		if(meistre==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		meistre=meistreDAO.find(meistre.getNumber());
		if(meistre==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		meistre=meistreDAO.find(meistre.getNumber());
		if(meistre==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		meistreDAO.update(meistre);
		return "/main-page";
	}
	
	public String excluir() {
		meistreDAO.deleteKey(meistre.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}
}
