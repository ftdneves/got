package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.BatalhaDAO;
import br.edu.unifei.ecoe18.got.dao.GrupoDAO;
import br.edu.unifei.ecoe18.got.modelo.Batalha;
import br.edu.unifei.ecoe18.got.modelo.Grupo;
import lombok.Data;

@Data
@Named
@RequestScoped
public class BatalhaBean implements Serializable{
	private static final long serialVersionUID = -8867020083955974855L;
	private Batalha batalha = new Batalha();
	private BatalhaDAO batalhaDAO = new BatalhaDAO();
	private GrupoDAO grupoDAO = new GrupoDAO();
	private Integer grupoVencedor;
	private List<String> codigosGrupos = grupoDAO.codigos();
	private List<Grupo> grupos = grupoDAO.findAll();
	
	public String inserir() {
		if(grupoVencedor!=null) {
			batalha.setVencedor(grupoDAO.find(grupoVencedor));
		}
		try {
			batalhaDAO.create(batalha);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		batalha=batalhaDAO.find(batalha.getData());
		if(batalha==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		batalha=batalhaDAO.find(batalha.getData());
		if(batalha==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		batalha=batalhaDAO.find(batalha.getData());
		if(batalha==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(grupoVencedor!=null) {
			batalha.setVencedor(grupoDAO.find(grupoVencedor));
		}
		batalhaDAO.update(batalha);
		return "/main-page";
	}
	
	public String excluir() {
		batalhaDAO.deleteKey(batalha.getData());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
	
}
