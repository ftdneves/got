package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.DragaoDAO;
import br.edu.unifei.ecoe18.got.dao.HumanoDAO;
import br.edu.unifei.ecoe18.got.dao.TransformacaoDAO;
import br.edu.unifei.ecoe18.got.modelo.Dragao;
import br.edu.unifei.ecoe18.got.modelo.Humano;
import br.edu.unifei.ecoe18.got.modelo.Transformacao;
import lombok.Data;

@Data
@Named
@RequestScoped
public class DragaoBean implements Serializable{
	private static final long serialVersionUID = -8916399191900703831L;
	private Dragao dragao = new Dragao();
	private DragaoDAO dragaoDAO = new DragaoDAO();
	
	private String draconiano;
	private HumanoDAO humanoDAO = new HumanoDAO();
	private List<Humano> humanos = humanoDAO.findAll();
	
	private String transformacao;
	private TransformacaoDAO transformacaoDAO = new TransformacaoDAO();
	private List<Transformacao> transformacoes = transformacaoDAO.findAll();
	
	public String inserir() {
		if(draconiano!=null) {
			dragao.setDraconiano(humanoDAO.find(draconiano));;
		}
		if(transformacao!=null) {
			dragao.setTransformacao(transformacaoDAO.find(transformacao));
		}	
		try {
			dragaoDAO.create(dragao);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		dragao=dragaoDAO.find(dragao.getNome());
		if(dragao==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		dragao=dragaoDAO.find(dragao.getNome());
		if(dragao==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		dragao=dragaoDAO.find(dragao.getNome());
		if(dragao==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(draconiano!=null) {
			dragao.setDraconiano(humanoDAO.find(draconiano));;
		}
		if(transformacao!=null) {
			dragao.setTransformacao(transformacaoDAO.find(transformacao));
		}	
		dragaoDAO.update(dragao);
		return "/main-page";
	}
	
	public String excluir() {
		dragaoDAO.deleteKey(dragao.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
	
}
