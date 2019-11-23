package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Patrulheiro extends Titulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1773859173538737707L;
	private String ordem;
	
}
