package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Grupo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8916649301378134026L;
	@Id
	@GeneratedValue
	private int codigo;
	private String motivacao;
	@OneToMany
	private List<Ser> seres = new ArrayList<>();
	
}
