package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Rei extends Titulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2731535959542667387L;
	@OneToOne
	private Casa casa;
	private String reinado;
	private float reputacao;
	
}
