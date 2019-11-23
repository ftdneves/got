package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Guerra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533166419274671981L;
	@Id
	@GeneratedValue
	private int numero;
	private String causas;
	private String resultado;
	@OneToMany
	private List<Batalha> batalhas = new ArrayList<>();
	@OneToOne
	private Grupo vitorioso;
	
}
