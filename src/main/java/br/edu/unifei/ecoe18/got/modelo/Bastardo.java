package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Bastardo extends Titulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3380954385764765257L;
	private boolean legitimado;
	
}
