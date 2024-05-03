package br.edu.senaisp.SpringDB.repository;

import java.util.List;

import br.edu.senaisp.SpringDB.model.Banda;

public interface ICrud {

	public List<Banda> lista();
	
	public Banda buscarPorId(int id);
	
	public Banda altera(Banda banda, int id);
	
	public void insere(Banda banda);
	
	public void exclui(int id);
	
}