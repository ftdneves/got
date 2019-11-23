package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Dragao extends Criatura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8215420220371528076L;
	private String chifres;
	private String escamas;
	private String fogo;
	@OneToOne
	private Humano draconiano;
	
}
