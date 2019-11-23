package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Nobre extends Titulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041918357455757593L;
	@ManyToOne
	private Casa casaLealdade;

}
