package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public abstract class Ser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2718185319663198212L;
	@Id
	private String nome;
	private String nascimento;
	private boolean morto;
	@OneToOne
	private Transformacao transformacao;
	
}
