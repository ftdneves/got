package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cavalo extends Criatura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8568994932434264435L;
	@Enumerated(EnumType.STRING)
	private RacaCavaloEnum raca;
	private String uso;
	@ElementCollection(targetClass = String.class)
	private List<String> caracteristicas;
	@Enumerated(EnumType.STRING)
	private CapacidadeReproducaoEnum capacidadeReproducao;
	@OneToOne
	private Humano cavaleiro;
	
		
}
