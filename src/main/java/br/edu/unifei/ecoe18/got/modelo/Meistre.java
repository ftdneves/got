package br.edu.unifei.ecoe18.got.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Meistre extends Titulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6248345051070356738L;
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = MetaisElosColarEnum.class)
	private List<MetaisElosColarEnum> elosColar = new ArrayList<>();
	
}
