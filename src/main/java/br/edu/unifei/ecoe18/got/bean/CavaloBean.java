package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.CavaloDAO;
import br.edu.unifei.ecoe18.got.dao.HumanoDAO;
import br.edu.unifei.ecoe18.got.dao.TransformacaoDAO;
import br.edu.unifei.ecoe18.got.modelo.CapacidadeReproducaoEnum;
import br.edu.unifei.ecoe18.got.modelo.Cavalo;
import br.edu.unifei.ecoe18.got.modelo.Humano;
import br.edu.unifei.ecoe18.got.modelo.RacaCavaloEnum;
import br.edu.unifei.ecoe18.got.modelo.Transformacao;
import lombok.Data;

@Data
@Named
@RequestScoped
public class CavaloBean implements Serializable{
	private static final long serialVersionUID = -8916399191900703831L;
	private Cavalo cavalo = new Cavalo();
	private CavaloDAO cavaloDAO = new CavaloDAO();
	private RacaCavaloEnum[] racas = RacaCavaloEnum.values();
	private CapacidadeReproducaoEnum[] capacidades = CapacidadeReproducaoEnum.values();
	
	private String cavaleiro;
	private HumanoDAO humanoDAO = new HumanoDAO();
	private List<Humano> humanos = humanoDAO.findAll();
	
	private String transformacao;
	private TransformacaoDAO transformacaoDAO = new TransformacaoDAO();
	private List<Transformacao> transformacoes = transformacaoDAO.findAll();
	
	public String inserir() {
		if(cavaleiro!=null) {
			cavalo.setCavaleiro(humanoDAO.find(cavaleiro));;
		}
		if(transformacao!=null) {
			cavalo.setTransformacao(transformacaoDAO.find(transformacao));
		}	
		try {
			cavaloDAO.create(cavalo);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(e.toString()));
			return "inserir";
		}
		return "/main-page";
	}
	
	public String buscarConsultar() {
		cavalo=cavaloDAO.find(cavalo.getNome());
		if(cavalo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	
	public String buscarAlterar() {
		cavalo=cavaloDAO.find(cavalo.getNome());
		if(cavalo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Não encontrado!"));
			return "buscar";
		}else {
			return "alterar";
		}
	}
	
	public String buscarExcluir() {
		cavalo=cavaloDAO.find(cavalo.getNome());
		if(cavalo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	
	public String alterar() {
		if(cavaleiro!=null) {
			cavalo.setCavaleiro(humanoDAO.find(cavaleiro));;
		}
		if(transformacao!=null) {
			cavalo.setTransformacao(transformacaoDAO.find(transformacao));
		}	
		cavaloDAO.update(cavalo);
		return "/main-page";
	}
	
	public String excluir() {
		cavaloDAO.deleteKey(cavalo.getNome());
		return "/main-page";
	}
	
	public String consultar() {
		return "/main-page";
	}	
}
