package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public abstract class Transformacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4658363327253015398L;
	@Id
	private String nome;
	
}
