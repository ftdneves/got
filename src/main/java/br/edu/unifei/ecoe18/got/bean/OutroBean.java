package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.OutroDAO;
import br.edu.unifei.ecoe18.got.dao.WightDAO;
import br.edu.unifei.ecoe18.got.modelo.Outro;
import br.edu.unifei.ecoe18.got.modelo.Wight;
import lombok.Data;

@Data
@Named
@RequestScoped
public class OutroBean implements Serializable{
	private static final long serialVersionUID = 9163864015895045766L;
	private Outro outro = new Outro();
	private OutroDAO outroDAO = new OutroDAO();

	private WightDAO wightDAO = new WightDAO();
	private List<Wight> wights = wightDAO.findAll();
	
	public String inserir() {
		try {
			outroDAO.create(outro);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		outro=outroDAO.find(outro.getNome());
		if(outro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		outro=outroDAO.find(outro.getNome());
		if(outro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		outro=outroDAO.find(outro.getNome());
		if(outro==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		outroDAO.update(outro);
		return "/main-page";
	}
	
	public String excluir() {
		outroDAO.deleteKey(outro.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}
}
