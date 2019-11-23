package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Lorde extends Titulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7368891223545188912L;
	private Casa casaComandada;
	
}
