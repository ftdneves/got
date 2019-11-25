package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.ContinenteDAO;
import br.edu.unifei.ecoe18.got.dao.RegiaoDAO;
import br.edu.unifei.ecoe18.got.dao.UnidadeDAO;
import br.edu.unifei.ecoe18.got.modelo.Continente;
import br.edu.unifei.ecoe18.got.modelo.Regiao;
import br.edu.unifei.ecoe18.got.modelo.Unidade;
import lombok.Data;

@Data
@Named
@RequestScoped
public class ContinenteBean implements Serializable{
	private static final long serialVersionUID = -8224532103050185225L;
	private Continente continente = new Continente();
	private ContinenteDAO continenteDAO = new ContinenteDAO();
	
	private UnidadeDAO unidadeDAO = new UnidadeDAO();
	private List<Unidade> unidades = unidadeDAO.findAll();
	
	private RegiaoDAO regiaoDAO = new RegiaoDAO();
	private List<Regiao> regioes = regiaoDAO.findAll();
	
	public String inserir() {
		try {
			continenteDAO.create(continente);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		continente=continenteDAO.find(continente.getNome());
		if(continente==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		continente=continenteDAO.find(continente.getNome());
		if(continente==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		continente=continenteDAO.find(continente.getNome());
		if(continente==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		continenteDAO.update(continente);
		return "/main-page";
	}
	
	public String excluir() {
		continenteDAO.deleteKey(continente.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
