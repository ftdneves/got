package br.edu.unifei.ecoe18.got.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

import java.util.ArrayList;


@Data
@Entity
public class Muralha {
	
	@Id
	@GeneratedValue
	private int codigo;
	private static final Muralha instancia = new Muralha();
	private String fundacao; 
	private String tamanho;
	@OneToMany
	private List<Patrulheiro> patrulheiros = new ArrayList<>();
	@OneToMany
	private List<Castelo> castelos = new ArrayList<Castelo>(19);
	@OneToOne
	private Patrulheiro senhorComandante;
	
	public Muralha() {	
		fundacao = "Há mais de 8 mil anos";
		tamanho = "200 metros de altura e 500 de extensão"; 
	}
	
	public static Muralha getInstancia() { return instancia; }
	
	
}
