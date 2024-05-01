package br.edu.senaisp.SpringDB.repository;

import java.util.List;

import br.edu.senaisp.SpringDB.model.Banda;

public interface ICrud {

	public List<Banda> lista();
	
	public Banda buscarPorId(int id);
	
	public Banda altera(String nome, int anolancamento, int id);
	
	public void insere(String nome, int anolancamento);
	
	public void exclui(int id);
	
}