package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Castelo extends Construcao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6837781056091906951L;
	private String defesas;
	@OneToOne
	private Casa casa;
	

}
