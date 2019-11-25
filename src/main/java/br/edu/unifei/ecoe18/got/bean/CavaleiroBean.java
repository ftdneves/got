package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CavaleiroDAO;
import br.edu.unifei.ecoe18.got.modelo.Cavaleiro;
import lombok.Data;

@Data
@Named
@RequestScoped
public class CavaleiroBean implements Serializable{
	private static final long serialVersionUID = -40081437296286564L;
	private Cavaleiro cavaleiro = new Cavaleiro();
	private CavaleiroDAO cavaleiroDAO = new CavaleiroDAO();
	
	private Integer mestre;
	private List<Cavaleiro> cavaleiros = cavaleiroDAO.findAll();
	
	public String inserir() {
		if(mestre!=null) cavaleiro.setMestre(cavaleiroDAO.find(mestre));
		try {
			cavaleiroDAO.create(cavaleiro);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		cavaleiro=cavaleiroDAO.find(cavaleiro.getNumber());
		if(cavaleiro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		cavaleiro=cavaleiroDAO.find(cavaleiro.getNumber());
		if(cavaleiro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		cavaleiro=cavaleiroDAO.find(cavaleiro.getNumber());
		if(cavaleiro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(mestre!=null) cavaleiro.setMestre(cavaleiroDAO.find(mestre));
		cavaleiroDAO.update(cavaleiro);
		return "/main-page";
	}
	
	public String excluir() {
		cavaleiroDAO.deleteKey(cavaleiro.getNumber());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
