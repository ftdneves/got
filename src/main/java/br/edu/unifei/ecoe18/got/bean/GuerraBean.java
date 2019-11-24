package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.BatalhaDAO;
import br.edu.unifei.ecoe18.got.dao.GrupoDAO;
import br.edu.unifei.ecoe18.got.dao.GuerraDAO;
import br.edu.unifei.ecoe18.got.modelo.Batalha;
import br.edu.unifei.ecoe18.got.modelo.Grupo;
import br.edu.unifei.ecoe18.got.modelo.Guerra;
import lombok.Data;

@Data
@Named
@RequestScoped
public class GuerraBean implements Serializable{
	private static final long serialVersionUID = -4110205859695520995L;
	private Guerra guerra = new Guerra();
	private GuerraDAO guerraDAO = new GuerraDAO();
	
	private BatalhaDAO batalhaDAO = new BatalhaDAO();
	private List<Batalha> batalhas = batalhaDAO.findAll();
	
	private GrupoDAO grupoDAO = new GrupoDAO();
	private List<Grupo> grupos = grupoDAO.findAll();
	private Integer grupoVitorioso;
	
	public String inserir() {
		if(grupoVitorioso!=null) {
			guerra.setVitorioso(grupoDAO.find(grupoVitorioso));
		}
		try {
			guerraDAO.create(guerra);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		guerra=guerraDAO.find(guerra.getNumero());
		if(guerra==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		guerra=guerraDAO.find(guerra.getNumero());
		if(guerra==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		guerra=guerraDAO.find(guerra.getNumero());
		if(guerra==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(grupoVitorioso!=null) {
			guerra.setVitorioso(grupoDAO.find(grupoVitorioso));
		}
		guerraDAO.update(guerra);
		return "/main-page";
	}
	
	public String excluir() {
		guerraDAO.deleteKey(guerra.getNumero());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
	
	
}
