package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Plebeu extends Titulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370076323721775720L;
	private String profissao;
	
}
