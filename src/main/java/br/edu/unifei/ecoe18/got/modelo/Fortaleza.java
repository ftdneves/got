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
public class Fortaleza extends Construcao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1904777416472318250L;
	@OneToMany
	private List<Castelo> castelos = new ArrayList<>();

	
}
