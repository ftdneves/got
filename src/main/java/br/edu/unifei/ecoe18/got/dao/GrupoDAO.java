package br.edu.unifei.ecoe18.got.dao;

import java.util.List;

import br.edu.unifei.ecoe18.got.modelo.Grupo;

public class GrupoDAO extends AbstractDAO<Grupo, Integer> {
	public List<String> codigos(){
		return getEntityManager().createQuery("select g.codigo from Grupo g").getResultList();
	}
}
