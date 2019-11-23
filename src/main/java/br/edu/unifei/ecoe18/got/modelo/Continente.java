package br.edu.unifei.ecoe18.got.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Continente extends Unidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -841187430048663536L;
	private String fronteiras;
	private String descricao;
	@OneToMany
	private List<Unidade> unidades = new ArrayList<>();
	@OneToMany
	private List<Regiao> regioes = new ArrayList<>();
	@OneToOne
	private static Muralha muralha = Muralha.getInstancia();
	

}
