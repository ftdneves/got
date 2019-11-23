package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Vila extends Construcao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5425690661235949492L;
	private String estrutura;

	
}
