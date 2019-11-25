package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.ConstrucaoDAO;
import br.edu.unifei.ecoe18.got.dao.RegiaoDAO;
import br.edu.unifei.ecoe18.got.modelo.Construcao;
import br.edu.unifei.ecoe18.got.modelo.Regiao;
import lombok.Data;

@Data
@Named
@RequestScoped
public class RegiaoBean implements Serializable{
	private static final long serialVersionUID = 38360506963732469L;
	private Regiao regiao = new Regiao();
	private RegiaoDAO regiaoDAO = new RegiaoDAO();
	
	private ConstrucaoDAO construcaoDAO = new ConstrucaoDAO();
	private List<Construcao> construcoes = construcaoDAO.findAll();
	
	public String inserir() {
		try {
			regiaoDAO.create(regiao);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		regiao=regiaoDAO.find(regiao.getNome());
		if(regiao==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		regiao=regiaoDAO.find(regiao.getNome());
		if(regiao==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		regiao=regiaoDAO.find(regiao.getNome());
		if(regiao==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		regiaoDAO.update(regiao);
		return "/main-page";
	}
	
	public String excluir() {
		regiaoDAO.deleteKey(regiao.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	

}
