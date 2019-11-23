package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Wight extends Transformacao implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7693432033931173745L;
	private String estadoDecomposicao;

	
	
}
