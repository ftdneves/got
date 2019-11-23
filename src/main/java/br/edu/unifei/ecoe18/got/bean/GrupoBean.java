package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.GrupoDAO;
import br.edu.unifei.ecoe18.got.modelo.Grupo;
import lombok.Data;

@Data
@Named
@RequestScoped
public class GrupoBean implements Serializable{
	private static final long serialVersionUID = -7952197974725096682L;
	private Grupo grupo = new Grupo();
	private GrupoDAO grupoDAO = new GrupoDAO();
	
	public String inserir() {
		try {
			grupoDAO.create(grupo);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Já existe essa data!"));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		grupo=grupoDAO.find(grupo.getCodigo());
		if(grupo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		grupo=grupoDAO.find(grupo.getCodigo());
		if(grupo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		grupo=grupoDAO.find(grupo.getCodigo());
		if(grupo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		grupoDAO.update(grupo);
		return "/main-page";
	}
	
	public String excluir() {
		grupoDAO.deleteKey(grupo.getCodigo());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}
}
