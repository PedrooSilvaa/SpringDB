package br.edu.senaisp.SpringDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.SpringDB.model.Banda;

@Repository
public class BandaRepository implements ICrud {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String qrSelectAll = "SELECT ID, NOME, ANOLANCAMENTO FROM banda;";
	private String SELECTPORID = "SELECT ID, NOME, ANOLANCAMENTO FROM banda WHERE ID = ?;";
	private static final String UPDATE = "UPDATE banda SET nome = ?, anolancamento = ? WHERE id = ?;";
	private static final String INSERT = "INSERT INTO banda (NOME, ANOLANCAMENTO) VALUES (?, ?);";
	private static final String DELETE = "DELETE FROM banda WHERE ID = ?;";
	
	@Override
	public List<Banda> lista() {
		
		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"),
					rs.getString("nome"),
					rs.getInt("anolancamento"));
					
		});
	}

	@Override
	public Banda buscarPorId(int id) {
		
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(SELECTPORID, 
				params,
				(rs, rowNum) -> {
					return new Banda(rs.getInt("id"),
							rs.getString("nome"),
							rs.getInt("anolancamento")
				);
					}
				);
	}

	@Override
	public Banda altera(Banda banda, int id) {
		Object[] params = {banda.getNome(), banda.getAnoLancamento(), id};
		
		jdbcTemplate.update(UPDATE, params);
		return null;
	}

	@Override
	public void insere(Banda banda) {
		Object[] params = {banda.getNome(), banda.getAnoLancamento()};
		
		jdbcTemplate.update(INSERT, params);
	
	}

	@Override
	public void exclui(int id) {
		jdbcTemplate.update(DELETE, id);
	}
	
}
