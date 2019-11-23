package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public abstract class Unidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7095266248905840970L;
	@Id
	private String nome;
	private String historia;
	@OneToMany
	private List<Ser> seres = new ArrayList<>();
	
	
}
