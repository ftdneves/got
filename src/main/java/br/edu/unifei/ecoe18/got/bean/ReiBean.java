package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CasaDAO;
import br.edu.unifei.ecoe18.got.dao.ReiDAO;
import br.edu.unifei.ecoe18.got.modelo.Casa;
import br.edu.unifei.ecoe18.got.modelo.Rei;
import lombok.Data;

@Data
@Named
@RequestScoped
public class ReiBean implements Serializable{
	private static final long serialVersionUID = 7648468879429127107L;
	private Rei rei = new Rei();
	private ReiDAO reiDAO = new ReiDAO();
	
	private String casa;
	private CasaDAO casaDAO = new CasaDAO();
	private List<Casa> casas = casaDAO.findAll(); 
	
	public String inserir() {
		if(casa!=null) rei.setCasa(casaDAO.find(casa));
		try {
			reiDAO.create(rei);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		rei=reiDAO.find(rei.getNumber());
		if(rei==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		rei=reiDAO.find(rei.getNumber());
		if(rei==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		rei=reiDAO.find(rei.getNumber());
		if(rei==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(casa!=null) rei.setCasa(casaDAO.find(casa));
		reiDAO.update(rei);
		return "/main-page";
	}
	
	public String excluir() {
		reiDAO.deleteKey(rei.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
