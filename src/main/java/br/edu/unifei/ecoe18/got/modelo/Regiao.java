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
public class Regiao extends Unidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3326951897359932283L;
	private String geografia;
	private String economia;
	private Casa suserana;
	@OneToMany
	private List<Construcao> construcoes = new ArrayList<>();

}
