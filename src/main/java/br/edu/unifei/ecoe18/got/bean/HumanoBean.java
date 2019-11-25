package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CavaloDAO;
import br.edu.unifei.ecoe18.got.dao.DragaoDAO;
import br.edu.unifei.ecoe18.got.dao.HumanoDAO;
import br.edu.unifei.ecoe18.got.dao.TituloDAO;
import br.edu.unifei.ecoe18.got.dao.TransformacaoDAO;
import br.edu.unifei.ecoe18.got.modelo.Cavalo;
import br.edu.unifei.ecoe18.got.modelo.Dragao;
import br.edu.unifei.ecoe18.got.modelo.Humano;
import br.edu.unifei.ecoe18.got.modelo.Titulo;
import br.edu.unifei.ecoe18.got.modelo.Transformacao;
import lombok.Data;

@Data
@Named
@RequestScoped
public class HumanoBean implements Serializable{
	private static final long serialVersionUID = -8916399191900703831L;
	private Humano humano = new Humano();
	private HumanoDAO humanoDAO = new HumanoDAO();
	
	private String pai;	
	private String mae;
	private List<Humano> humanos = humanoDAO.findAll();
	
	private String transformacao;
	private TransformacaoDAO transformacaoDAO = new TransformacaoDAO();
	private List<Transformacao> transformacoes = transformacaoDAO.findAll();
	
	private Integer titulo;
	private TituloDAO tituloDAO = new TituloDAO();
	private List<Titulo> titulos = tituloDAO.findAll();
	
	private String dragao;
	private DragaoDAO dragaoDAO = new DragaoDAO();
	private List<Dragao> dragoes = dragaoDAO.findAll();
	
	private String cavalo;
	private CavaloDAO cavaloDAO = new CavaloDAO();
	private List<Cavalo> cavalos = cavaloDAO.findAll();
	
	public String inserir() {
		if(pai!=null && mae!=null) {
			humano.setPai(humanoDAO.find(pai));
			humano.setMae(humanoDAO.find(mae));
		}
		if(dragao!=null) {
			humano.setDragao(dragaoDAO.find(dragao));
		}
		if(cavalo!=null) {
			humano.setCavalo(cavaloDAO.find(cavalo));
		}
		if(transformacao!=null) {
			humano.setTransformacao(transformacaoDAO.find(transformacao));
		}
		if(titulo!=null) {
			humano.setTitulo(tituloDAO.find(titulo));
		}
		try {
			humanoDAO.create(humano);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		humano=humanoDAO.find(humano.getNome());
		if(humano==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		humano=humanoDAO.find(humano.getNome());
		if(humano==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		humano=humanoDAO.find(humano.getNome());
		if(humano==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(pai!=null && mae!=null) {
			humano.setPai(humanoDAO.find(pai));
			humano.setMae(humanoDAO.find(mae));
		}
		if(dragao!=null) {
			humano.setDragao(dragaoDAO.find(dragao));
		}
		if(cavalo!=null) {
			humano.setCavalo(cavaloDAO.find(cavalo));
		}
		if(transformacao!=null) {
			humano.setTransformacao(transformacaoDAO.find(transformacao));
		}
		if(titulo!=null) {
			humano.setTitulo(tituloDAO.find(titulo));
		}	
		humanoDAO.update(humano);
		return "/main-page";
	}
	
	public String excluir() {
		humanoDAO.deleteKey(humano.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
