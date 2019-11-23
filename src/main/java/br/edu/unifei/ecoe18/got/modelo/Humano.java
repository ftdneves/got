package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Humano extends Ser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -41180908125634428L;
	private String apelido;
	@OneToOne
	private Dragao dragao;
	@OneToOne
	private Cavalo cavalo;
	@OneToOne
	private Humano pai;
	@OneToOne
	private Humano mae;
	@OneToOne
	private Titulo titulo;
	
}
