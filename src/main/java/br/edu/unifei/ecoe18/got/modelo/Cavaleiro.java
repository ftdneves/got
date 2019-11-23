package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cavaleiro extends Titulo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3733798681557268718L;
	@OneToOne
	private Cavaleiro mestre;
	private String tipo;
	
}
