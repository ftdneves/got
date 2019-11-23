package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Outro extends Transformacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4609783829339145020L;
	private String arma;
	@OneToMany
	private List<Wight> transformados = new ArrayList<>();
	
}
