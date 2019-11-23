package br.edu.unifei.ecoe18.got.modelo;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Construcao extends Unidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3856395184173443698L;
	private boolean ruina;
	private boolean abandonado;
	private String fundacao;
	private String localizacao;
	
	
}
