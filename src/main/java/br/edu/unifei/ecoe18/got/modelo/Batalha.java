package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Batalha implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1116692686536327285L;
	@Id
	private String data;
	private String local;
	private String resultado;
	@OneToMany
	private List<Grupo> grupos = new ArrayList<>();
	@OneToOne
	private Grupo vencedor;
	
	
}
