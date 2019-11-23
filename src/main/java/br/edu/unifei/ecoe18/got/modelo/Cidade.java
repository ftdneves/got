package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cidade extends Construcao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 308735124502498058L;
	@OneToOne
	private Casa soberana;
		
}
