package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CasaDAO;
import br.edu.unifei.ecoe18.got.dao.NobreDAO;
import br.edu.unifei.ecoe18.got.modelo.Casa;
import br.edu.unifei.ecoe18.got.modelo.Nobre;
import lombok.Data;

@Data
@Named
@RequestScoped
public class NobreBean implements Serializable{
	private static final long serialVersionUID = 7972182271179969331L;
	private Nobre nobre = new Nobre();
	private NobreDAO nobreDAO = new NobreDAO();
	
	private String casa;
	private CasaDAO casaDAO = new CasaDAO();
	private List<Casa> casas = casaDAO.findAll(); 
	
	public String inserir() {
		if(casa!=null) nobre.setCasaLealdade(casaDAO.find(casa));
		try {
			nobreDAO.create(nobre);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		nobre=nobreDAO.find(nobre.getNumber());
		if(nobre==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		nobre=nobreDAO.find(nobre.getNumber());
		if(nobre==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		nobre=nobreDAO.find(nobre.getNumber());
		if(nobre==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(casa!=null) nobre.setCasaLealdade(casaDAO.find(casa));
		nobreDAO.update(nobre);
		return "/main-page";
	}
	
	public String excluir() {
		nobreDAO.deleteKey(nobre.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
