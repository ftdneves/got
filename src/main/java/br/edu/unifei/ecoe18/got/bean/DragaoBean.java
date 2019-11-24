package br.edu.unifei.ecoe18.got.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unifei.ecoe18.got.dao.DragaoDAO;
import br.edu.unifei.ecoe18.got.dao.HumanoDAO;
import br.edu.unifei.ecoe18.got.modelo.Dragao;
import br.edu.unifei.ecoe18.got.modelo.Humano;
import lombok.Data;

@Data
@Named
@RequestScoped
public class DragaoBean implements Serializable{
	private static final long serialVersionUID = -8916399191900703831L;
	private Dragao dragao = new Dragao();
	private DragaoDAO dragaoDAO = new DragaoDAO();
	
	private HumanoDAO humanoDAO = new HumanoDAO();
	private List<Humano> humanos = humanoDAO.findAll();
	
	
	
}
