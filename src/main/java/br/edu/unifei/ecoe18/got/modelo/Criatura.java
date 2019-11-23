package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Criatura extends Ser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3317509087459402469L;
	private String Classe;
	
}
