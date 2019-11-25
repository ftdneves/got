package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CasaDAO;
import br.edu.unifei.ecoe18.got.dao.LordeDAO;
import br.edu.unifei.ecoe18.got.modelo.Casa;
import br.edu.unifei.ecoe18.got.modelo.Lorde;
import lombok.Data;

@Data
@Named
@RequestScoped
public class LordeBean implements Serializable{
	private static final long serialVersionUID = 1263653570658498941L;
	private Lorde lorde = new Lorde();
	private LordeDAO lordeDAO = new LordeDAO();
	
	private String casa;
	private CasaDAO casaDAO = new CasaDAO();
	private List<Casa> casas = casaDAO.findAll(); 
	
	public String inserir() {
		if(casa!=null) lorde.setCasaComandada(casaDAO.find(casa));
		try {
			lordeDAO.create(lorde);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		lorde=lordeDAO.find(lorde.getNumber());
		if(lorde==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		lorde=lordeDAO.find(lorde.getNumber());
		if(lorde==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		lorde=lordeDAO.find(lorde.getNumber());
		if(lorde==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(casa!=null) lorde.setCasaComandada(casaDAO.find(casa));
		lordeDAO.update(lorde);
		return "/main-page";
	}
	
	public String excluir() {
		lordeDAO.deleteKey(lorde.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
