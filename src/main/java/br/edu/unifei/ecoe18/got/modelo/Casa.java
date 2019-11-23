package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Casa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1042806025970897159L;
	@Id
	private String nome;
	private String lema;
	private String brasao;
	private String historia;
	private String fundacao;
	private String armaAncestral;
	@OneToOne
	private Lorde lorde;
	@OneToMany
	private List<Nobre> membros = new ArrayList<>();
	@OneToOne
	private Castelo castelo;
	
}
