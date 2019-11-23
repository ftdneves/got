package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public abstract class Titulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7731534054842692400L;
	@Id
	@GeneratedValue
	private int number;
}
